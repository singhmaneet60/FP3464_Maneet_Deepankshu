public abstract class Contract {
    protected int daysWorked;
    private double Bonus;

    public Contract(double bonus, int childAllowance) {
    }

    public Contract( int numberOfChildren,  boolean b, int i, double Bonus,  int childAllowance) {
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

    public double Bonus() {
        return Bonus;
    }
    private String isMarried(boolean isMarried) {
        return isMarried ? "Married" : "Not Married";
    }

    public void setMoneyPremium(double Bonus) {
        this.Bonus = Bonus;
    }
}

class Permanent extends Contract {
    private double fixedMonthlySalary;
    private int numberOfChildren;
    private boolean isMarried;

    private double childAllowance;

    private static final double BONUS_PER_CHILD = 200.0;
    private static final double MARRIAGE_BONUS = 500.0;

    public Permanent(int numberOfChildren,boolean isMarried,int fixedMonthlySalary,int Bonus, int daysWorked) {
        super(numberOfChildren, isMarried, fixedMonthlySalary, Bonus, daysWorked); // This should be the first statement in the constructor
        this.fixedMonthlySalary = fixedMonthlySalary;
        this.numberOfChildren = numberOfChildren;
        this.isMarried = isMarried;
        this.daysWorked = daysWorked;
    }

    public Permanent(int numberOfChildren,boolean b,  int fixedMonthlySalary, double Bonus, int daysWorked) {
        super( numberOfChildren,b,  fixedMonthlySalary, Bonus,  daysWorked);
    }


    public double calculateAccumulatedSalary ( double fixedMonthlySalary, int numberOfChildren, boolean isMarried,
                                               double childAllowance){
        // Add any additional bonus calculations based on specific requirements
        return daysWorked * (fixedMonthlySalary + calculateChildBonus() + calculateMarriageBonus()) / 20;
    }



    public String getContractInfo() {
        return "He/She is " + (isMarried ? "married" : "not married") +" and he/she has " + numberOfChildren+" children.\n" +
                "He/She has worked for " + daysWorked + " days and upon contract his/her monthly\nsalary is " +
                fixedMonthlySalary +"\n";


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
        // Add any additional bonus calculations based on specific requirements
        return daysWorked * (fixedMonthlySalary + calculateChildBonus() + calculateMarriageBonus()) / 20;
    }
    @Override
    public String convertToContract() {
        // Implementation for converting to PermanentContract
        return "Permanent Contract Details...";
    }

}

class Temporary extends Contract {
    private final double hourlySalary;

    public Temporary( double hourlySalary,int daysWorked) {
        super(hourlySalary,daysWorked);

        this.hourlySalary = hourlySalary;
        this.daysWorked = daysWorked;
    }

    @Override
    public double calculateAccumulatedSalary() {
        // Calculate salary for temporary contract based on hourly wage and hours worked
        return daysWorked * 8 * hourlySalary;
    }

    @Override
    public String getContractInfo() {
        return "he is a Temporary employee with  " + hourlySalary + "\n" +
                "hourly salary and he has worked for " + daysWorked  + " hours\n";
    }

    @Override
    public String convertToContract() {
        // Implementation for converting to TemporaryContract
        return "Temporary Contract Details...";
    }
}

