public abstract class Contract {
    protected int daysWorked;

    public Contract(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public Contract(int daysWorked, boolean b, int numberOfChildren, int i, int childAllowance) {
    }


    public abstract double calculateAccumulatedSalary();

    public abstract String getContractInfo();

    public  abstract String convertToContract();

    public double convertToContract(Contract newContract) {
        return 0;
    }

    public double calculateAccumulatedSalary(int daysOrHoursWorked) {
        return 0;
    }
}

class Permanent extends Contract {
    private double fixedMonthlySalary;
    private int numberOfChildren;
    private boolean isMarried;
    private double childAllowance;

    private static final double BONUS_PER_CHILD = 200.0;
    private static final double MARRIAGE_BONUS = 500.0;

    public Permanent(int daysWorked, double fixedMonthlySalary, int numberOfChildren, boolean isMarried, double childAllowance) {
        super(daysWorked); // This should be the first statement in the constructor
        this.fixedMonthlySalary = fixedMonthlySalary;
        this.numberOfChildren = numberOfChildren;
        this.isMarried = isMarried;
        this.childAllowance = childAllowance;
    }

    public Permanent(int daysWorked, boolean b, int numberOfChildren, int i, int childAllowance) {
        super(daysWorked, b, numberOfChildren, i, childAllowance);
    }





    public double calculateAccumulatedSalary ( double fixedMonthlySalary, int numberOfChildren, boolean isMarried,
        double childAllowance){
        // Add any additional bonus calculations based on specific requirements
            return daysWorked * (fixedMonthlySalary + calculateChildBonus() + calculateMarriageBonus()) / 20;
        }

        public String getContractInfo () {
            return "Permanent Contract: Fixed Monthly Salary - $" + fixedMonthlySalary +
                    ", Number of Children - " + numberOfChildren +
                    ", Married - " + isMarried +
                    ", Child Allowance - $" + childAllowance;
        }

        private double calculateChildBonus () {
            return numberOfChildren * BONUS_PER_CHILD;
        }

        private double calculateMarriageBonus () {
            return isMarried ? MARRIAGE_BONUS : 0;
        }
    @Override
    public double calculateAccumulatedSalary() {
        // Implement the calculation logic for accumulated salary in PermanentContract
        double baseSalary = daysWorked * (fixedMonthlySalary + calculateChildBonus() + calculateMarriageBonus()) / 20;
        // Add any additional bonus calculations based on specific requirements
        return baseSalary;
    }
    @Override
    public String convertToContract() {
        // Implementation for converting to PermanentContract
        return "Permanent Contract Details...";
    }



}

class Temporary extends Contract {
    private double hourlySalary;

    public Temporary(int daysWorked, double hourlySalary) {
        super(daysWorked);
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double calculateAccumulatedSalary() {
        // Calculate salary for temporary contract based on hourly wage and hours worked
        return daysWorked * 8 * hourlySalary;
    }

    @Override
    public String getContractInfo() {
        return "Temporary Contract: Hourly Salary - $" + hourlySalary +
                ", Hours Worked - " + (daysWorked * 8);
    }

    @Override
    public String convertToContract() {
        // Implementation for converting to TemporaryContract
        return "Temporary Contract Details...";
    }
}

