import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Demo class serves as the driver application for Project 2.
 * It reads insurance policy records sequentially from an external text file,
 * dynamically instantiates Policy objects, stores them inside an ArrayList,
 * and prints out individual details alongside cumulative tracking metrics.
 * * @author Rylee Redden
 * @version 2.0
 */
public class Demo {

    /**
     * The main entry point of the program execution.
     * It handles initializing file streams, parsing file contents, accumulating 
     * statistics on policyholder smoking habits, and printing structural layouts.
     * * @param args Standard command-line string arguments (not utilized).
     * @throws IOException If the target file "PolicyInformation.txt" is missing or unreadable.
     */
    public static void main(String[] args) throws IOException {
        // 1. Create the file object pointing to your data file
        File file = new File("PolicyInformation.txt");
        
        // Safety check to ensure the file exists before reading
        if (!file.exists()) {
            System.out.println("Error: PolicyInformation.txt not found.");
            return;
        }

        // 2. Initialize the Scanner to read from the text file instead of System.in
        Scanner fileScanner = new Scanner(file);

        // 3. Initialize the dynamic ArrayList to hold an arbitrary number of Policy objects
        ArrayList<Policy> policyList = new ArrayList<>();

        // Counters for tracking smoking status statistics
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // 4. Loop through the file until there is no more data left to parse
        while (fileScanner.hasNext()) {
            int policyNum = fileScanner.nextInt();
            fileScanner.nextLine(); // Clear the newline buffer after reading an int
            
            String provider = fileScanner.nextLine();
            String first = fileScanner.nextLine();
            String last = fileScanner.nextLine();
            
            int age = fileScanner.nextInt();
            fileScanner.nextLine(); // Clear the newline buffer after reading an int
            
            String smoker = fileScanner.nextLine();
            double height = fileScanner.nextDouble();
            double weight = fileScanner.nextDouble();
            
            // Consume the trailing whitespace/newlines at the end of the data block
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine(); // Consumes any blank line spacing between policy segments
            }

            // Instantiate a new Policy object using the parsed data tokens
            Policy policy = new Policy(policyNum, provider, first, last, age, smoker, height, weight);
            
            // Add the created object into our dynamic storage array
            policyList.add(policy);
        }

        // Close the file parser stream
        fileScanner.close();

        // 5. Iterate through the ArrayList to print out details and aggregate data
        for (Policy policy : policyList) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.printf("Policyholder's Height: %.1f inches\n", policy.getHeight());
            System.out.printf("Policyholder's Weight: %.1f pounds\n", policy.getWeight());
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            
            // NOTE: Double check your calculation method name in Policy.java! 
            // Change below to calculatePrice() if your method is named that way.
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
            System.out.println(); // Prints a blank line separating individual entries

            // Track summary metrics dynamically
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else if (policy.getSmokingStatus().equalsIgnoreCase("non-smoker")) {
                nonSmokerCount++;
            }
        }

        // 6. Display cumulative tracking totals exactly as required by the sample output
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}