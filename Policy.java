public class Policy {
    // Private attributes (Fields)
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height;        // in inches
    private double weight;        // in pounds

    /**
     * No-arg constructor initializing fields to default values.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Overloaded constructor to fully initialize the Policy object.
     */
    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // ==================== MUTATORS (SETTERS) ====================
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

    // ==================== ACCESSORS (GETTERS) ====================
    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSmokingStatus() { return smokingStatus; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    // ==================== CORE CALCULATIONS ====================

    /**
     * Dynamically calculates and returns the BMI of the policyholder.
     * Formula: (Weight * 703) / (Height^2)
     */
    public double calculateBMI() {
        if (height == 0) return 0.0; // Avoid potential division by zero
        return (weight * 703) / (height * height);
    }

    /**
     * Dynamically calculates and returns the total price of the insurance policy.
     */
    public double calculatePrice() {
        double price = 600.0; // Base fee

        if (age > 50) {
            price += 75.0;
        }
        
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }
}