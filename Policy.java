public class Policy {
    // Step 3: Static attribute to keep track of total Policy objects created
    private static int policyCount = 0;

    // Private attributes (Fields)
    private int policyNumber;
    private String providerName;
    
    // Step 4: Class Collaboration (Aggregation - A Policy "has-a" PolicyHolder)
    private PolicyHolder policyHolder;

    /**
     * No-arg constructor initializing fields to default values.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++; // Increment counter whenever an object is instantiated
    }

    /**
     * Overloaded constructor to fully initialize the Policy object.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Step 5 Security: Deep copy the object to avoid security/privacy leaks
        this.policyHolder = new PolicyHolder(policyHolder); 
        policyCount++; // Increment counter whenever an object is instantiated
    }

    // ================= MUTATORS (SETTERS) =================
    public void setPolicyNumber(int policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    
    // Step 5 Security: Set using a deep copy
    public void setPolicyHolder(PolicyHolder policyHolder) { 
        this.policyHolder = new PolicyHolder(policyHolder); 
    }

    // ================= ACCESSORS (GETTERS) =================
    public int getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    
    // Step 5 Security: Return a deep copy instead of the direct reference
    public PolicyHolder getPolicyHolder() { 
        return new PolicyHolder(this.policyHolder); 
    }

    /**
     * Step 3: Static accessor to get the global policy object count.
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Dynamically calculates and returns the total price of the insurance policy.
     */
    public double calculatePrice() {
        double price = 600.0; // Base fee

        if (policyHolder.getAge() > 50) {
            price += 75.0;
        }
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        
        double bmi = policyHolder.getBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }

    /**
     * Step 2: Returns a formatted String representation of the Policy.
     * Note: %s with this.policyHolder implicitly triggers PolicyHolder's toString().
     */
    @Override
    public String toString() {
        return String.format(
            "Policy Number: %d\n" +
            "Provider Name: %s\n" +
            "%s\n" +
            "Policy Price: $%.2f\n",
            policyNumber, providerName, policyHolder, calculatePrice()
        );
    }
}