import java.time.Year;

public abstract class Employee {
    //test
    private final String Name;
    private int BirthYear;

    private double MontlyIncome;
    private int OccupationRate;

    private Vehicle vehicle;

    private Contract contract;

    public  abstract double annualincome();

    // Constructor for initializing basic information of an Employee
    public Employee(String name, int birthYear) {
        this.Name = name;
        this.BirthYear = birthYear;
        this.OccupationRate = 100;
        this.MontlyIncome = 1200;
        System.out.println("We have a new employee :" + this.getName()+ " , a " + this.getClass().getName());
    }

    // Constructor with occupation rate, ensuring a minimum value
    public Employee(String name, int birthYear, int occupationRate) {
        this(name, birthYear);
        if(occupationRate < 10){
            this.OccupationRate = 10;
        } else this.OccupationRate = Math.min(occupationRate, 100);
    }

    // Constructor with a vehicle
    public Employee(String name, int birthYear, Vehicle vehicle){
        this(name, birthYear);
        this.vehicle = vehicle;
    }

    // Constructor with occupation rate and a vehicle
    public Employee(String name, int birthYear, int occupationRate, Vehicle vehicle){
        this(name, birthYear, occupationRate);
        this.vehicle = vehicle;
    }

    //getter and setter methods
    public String getName() {
        return Name;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public double getMontlyIncome() {
        return MontlyIncome;
    }

    public void setMontlyIncome(double montlyIncome) {
        MontlyIncome = montlyIncome;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }


    public int getOccupationRate() {
        return OccupationRate;
    }


    public int getAge(){
        return Year.now().getValue() - getBirthYear();
    }
    public void signContract(Contract p1){
        this.setContract(p1);
    }

    //abstract method for contranctInfo
    public abstract String contractInfo();

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Contract getContract() {
        return contract;
    }

    //setter method for setContract to change the contract from permanent to temporary and vice versa
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public String toString(){
        StringBuilder totalBuilder = new StringBuilder();
        totalBuilder.append( "Name: " ).append(this.getName()).append( " is a" ).append(this.getClass().getName()).append("\n");
        Vehicle vehicle = this.getVehicle();

        if (vehicle != null) {
            totalBuilder.append(vehicle);
        }

        return totalBuilder.toString();
    }
}

class Manager extends Employee
{
    private int travelledDays;

    private int newClients;

    private final double GAIN_FACTOR_CLIENT = 500;

    private final double GAIN_FACTOR_TRAVEL = 100;


    // Constructor for a Manager with basic information, newClients, and travelledDays
    public Manager(String name, int birthYear, int newClients, int travelledDays ) {
        super(name, birthYear);
        if(IsValidateInputs(travelledDays, newClients)){
            this.travelledDays = travelledDays;
            this.newClients = newClients;
        }else {
            throw new IllegalArgumentException("invalid input for travel days or client number");
        }
    }

    // Constructor for a Manager with basic information, newClients, travelledDays, and occupationRate
    public Manager(String name, int birthYear, int newClients, int travelledDays, int occupationRate){
        super(name, birthYear, occupationRate);
        if(IsValidateInputs(travelledDays, newClients)){
            this.travelledDays = travelledDays;
            this.newClients = newClients;
        }else {
            throw new IllegalArgumentException("invalid input for travel days or client number");
        }
    }

    // Constructor for a Manager with basic information, newClients, travelledDays, and a vehicle
    public Manager(String name, int birthYear, int newClients, int travelledDays, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        if(IsValidateInputs(travelledDays, newClients)){
            this.travelledDays = travelledDays;
            this.newClients = newClients;
        }else {
            throw new IllegalArgumentException("invalid input for travel days or client number");
        }
    }

    // Constructor for a Manager with basic information, newClients, travelledDays, occupationRate, and a vehicle
    public Manager(String name, int birthYear, int newClients, int travelledDays, int occupationRate, Vehicle vehicle){
        super(name, birthYear, occupationRate, vehicle);
        if(IsValidateInputs(travelledDays, newClients)){
            this.travelledDays = travelledDays;
            this.newClients = newClients;
        }else {
            throw new IllegalArgumentException("invalid input for travel days or client number");
        }
    }

    // Helper method to validate inputs for newClients and travelledDays
    private boolean IsValidateInputs(int travelledDays, int newClients) {
        return travelledDays >= 0 && newClients >= 0;
    }

    //getter and setter methods
    public int getTravelledDays() {
        return travelledDays;
    }

    public void setTravelledDays(int travelledDays) {
        this.travelledDays = travelledDays;
    }

    public int getNewClients() {
        return newClients;
    }

    public void setNewClients(int newClients) {
        this.newClients = newClients;
    }

    public double getGAIN_FACTOR_CLIENT() {
        return GAIN_FACTOR_CLIENT;
    }

    public double getGAIN_FACTOR_TRAVEL() {
        return GAIN_FACTOR_TRAVEL;
    }

    // Method to calculate the annual income of the Manager
    @Override
    public double annualincome() {
        double base = getMontlyIncome() * 12;
        double extra = GAIN_FACTOR_CLIENT *  getNewClients();
        double extra2 = GAIN_FACTOR_TRAVEL * getTravelledDays();
        return extra + base + extra2 ;
    }

    // Method to provide information about the Manager's contract
    @Override
    public String contractInfo() {
        return this.getName() + " is a Manager " + getContract().getContractInfo();
    }

    // Method to generate a string representation of the Manager

    public String toString(){
        return super.toString() + GetManagerInfo();
    }

    // Helper method to provide additional information about the Manager
    private String GetManagerInfo() {
        return this.getName() + " has an Occupation rate:" + this.getOccupationRate()
                + "% he/she travelled " + this.getTravelledDays() + " days and has brought "
                + this.getNewClients() + " new clients. \n " +
                "His/Her estimated annual income is " + this.annualincome();
    }
}
class Programmer extends Employee
{
    private int noProjects;

    private final double GAIN_FACTOR_PROJECTS = 200;


    // Constructor for a Programmer with basic information and number of projects
    public Programmer(String name, int birthYear, int noProjects) {
        super(name,birthYear);
        if(IsValidateInputs(noProjects)){
            this.noProjects = noProjects;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Programmer with basic information, number of projects, and occupationRate
    public Programmer(String name, int birthYear, int noProjects, int occupationRate) {
        super(name,birthYear,occupationRate);
        if(IsValidateInputs(noProjects)){
            this.noProjects = noProjects;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Programmer with basic information, number of projects, and a vehicle
    public Programmer(String name, int birthYear, int noProjects, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        if(IsValidateInputs(noProjects)){
            this.noProjects = noProjects;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Programmer with basic information, number of projects, occupationRate, and a vehicle
    public Programmer(String name, int birthYear, int noProjects, int occupationRate, Vehicle vehicle) {
        super(name, birthYear, occupationRate, vehicle);
        if(IsValidateInputs(noProjects)){
            this.noProjects = noProjects;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Helper method to validate the input for the number of projects
    private boolean IsValidateInputs(int noProjects) {
        return noProjects >= 0;
    }

    public double getGAIN_FACTOR_PROJECTS() {
        return GAIN_FACTOR_PROJECTS;
    }


    public int getNoProjects() {
        return noProjects;
    }

    public void setNoProjects(int noProjects) {
        this.noProjects = noProjects;
    }

    // Method to calculate the annual income of the Programmer
    @Override
    public double annualincome() {
        double base = getMontlyIncome() * 12;
        double extra = GAIN_FACTOR_PROJECTS *  getNoProjects();
        return extra + base ;
    }

    @Override
    public void signContract(Contract p1) {
        this.setContract(p1);
    }

    // Method to provide information about the Programmer's contract
    @Override
    public String contractInfo() {
        return this.getName() + " is a Programmer " + getContract().getContractInfo();
    }

    // Method to generate a string representation of the Programmer
    public String toString(){
        return super.toString() + GetProgrammerInfo();
    }

    // Helper method to provide additional information about the Programmer
    private String GetProgrammerInfo() {
        return this.getName() + " has an Occupation rate:" + this.getOccupationRate()
                + "% and completed " + this.getNoProjects() + " projects. \n "
                + "His/Her estimated annual income is " + this.annualincome();
    }
}

class Tester extends Employee
{
    private int noBugs;

    private final double GAIN_FACTOR_ERROR = 10;

    // Constructor for a Tester with basic information and number of bugs
    public Tester(String name, int birthYear, int noBugs) {
        super(name, birthYear);
        if(IsValidateInputs(noBugs)){
            this.noBugs = noBugs;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Tester with basic information, number of bugs, and occupationRate
    public Tester(String name, int birthYear, int noBugs, int occupationRate) {
        super(name, birthYear, occupationRate);
        if(IsValidateInputs(noBugs)){
            this.noBugs = noBugs;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Tester with basic information, number of bugs, and a vehicle
    public Tester(String name, int birthYear, int noBugs, Vehicle vehicle) {
        super(name, birthYear, vehicle);
        if(IsValidateInputs(noBugs)){
            this.noBugs = noBugs;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Constructor for a Tester with basic information, number of bugs, occupationRate, and a vehicle
    public Tester(String name, int birthYear, int noBugs, int occupationRate, Vehicle vehicle) {
        super(name, birthYear, occupationRate, vehicle);
        if(IsValidateInputs(noBugs)){
            this.noBugs = noBugs;
        }else {
            throw new IllegalArgumentException("invalid input for number of projects");
        }
    }

    // Helper method to validate the input for the number of bugs
    private boolean IsValidateInputs(int noBugs) {
        return noBugs >= 0;
    }

    public double getGAIN_FACTOR_ERROR() {
        return GAIN_FACTOR_ERROR;
    }


    public int getNoBugs() {
        return noBugs;
    }

    public void setNoBugs(int noBugs) {
        this.noBugs = noBugs;
    }

    // Method to calculate the annual income of the Tester
    @Override
    public double annualincome() {
        double base = getMontlyIncome() * 12;
        double extra = GAIN_FACTOR_ERROR *  getNoBugs();
        return extra + base ;

    }

    //method to change to contract
    @Override
    public void signContract(Contract p1) {
        this.setContract(p1);
    }

    //method to get contract info

    @Override
    public String contractInfo() {
        return this.getName() + " is a Tester " + getContract().getContractInfo();
    }

    // Method to generate a string representation of the Tester
    public String toString(){
        return super.toString() + GetTesterInfo();
    }

    // Helper method to provide additional information about the Tester
    private String GetTesterInfo() {
        return this.getName() + " has an Occupation rate:" + this.getOccupationRate()
                + "% and corrected " + this.getNoBugs() + " Bugs. \n "
                + "His/Her estimated annual income is " + this.annualincome();
    }
}