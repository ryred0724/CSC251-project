import java.util.Scanner;

public class Project_rylee_redden { 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // 1. Gather all the inputs from the user
        System.out.print("Please enter the Policy Number: ");
        int policyNum = keyboard.nextInt();
        keyboard.nextLine(); // Clear the buffer newline

        System.out.print("Please enter the Provider Name: ");
        String provider = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's First Name: ");
        String first = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String last = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's Age: ");
        int age = keyboard.nextInt();
        keyboard.nextLine(); // Clear buffer

        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smoker = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = keyboard.nextDouble();

        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = keyboard.nextDouble();

        // 2. Class Collaboration: First create the PolicyHolder (the person)
        PolicyHolder holder = new PolicyHolder(first, last, age, smoker, height, weight);

        // 3. Create the Policy, passing the holder object into it (Aggregation)
        Policy policy = new Policy(policyNum, provider, holder);

        // Track smoker vs non-smoker counts for the final display
        int smokerCount = 0;
        int nonSmokerCount = 0;

        if (policy.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
            smokerCount++;
        } else {
            nonSmokerCount++;
        }

        // 4. Step 6: Print information implicitly calling the toString() method
        System.out.println("\n" + policy);

        // 5. Step 7: Display the tracking counters and static object counts
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
        
        keyboard.close();
    }
}