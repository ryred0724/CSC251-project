public class PolicyHolder {
    // Attributes specific to the person
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    // No-arg constructor
    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    // Parameterized constructor
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Copy Constructor (Crucial for Step 5: Security Holes in Aggregation)
     */
    public PolicyHolder(PolicyHolder object2) {
        if (object2 != null) {
            this.firstName = object2.firstName;
            this.lastName = object2.lastName;
            this.age = object2.age;
            this.smokingStatus = object2.smokingStatus;
            this.height = object2.height;
            this.weight = object2.weight;
        }
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    /**
     * Calculates the BMI of the policy holder
     */
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Step 2: toString Method for PolicyHolder
     */
    @Override
    public String toString() {
        return String.format(
            "Policyholder's First Name: %s\n" +
            "Policyholder's Last Name: %s\n" +
            "Policyholder's Age: %d\n" +
            "Policyholder's Smoking Status (Y/N): %s\n" +
            "Policyholder's Height: %.1f inches\n" +
            "Policyholder's Weight: %.1f pounds\n" +
            "Policyholder's BMI: %.2f",
            firstName, lastName, age, smokingStatus, height, weight, getBMI()
        );
    }
}