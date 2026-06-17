import java.util.Scanner;

public class Demo
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

        // 2. Instantiate the Policy object using your constructor
        // Note: Make sure your constructor in Policy.java sets height and weight fields!
        Policy policy = new Policy(policyNum, provider, first, last, age, smoker, height, weight);

        // 3. Print the formatted outputs to match the sample assignment layout
        System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.printf("Policyholder's Height: %.1f inches\n", policy.getHeight());
        System.out.printf("Policyholder's Weight: %.1f pounds\n", policy.getWeight());
        System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
        
        keyboard.close();
    }
}