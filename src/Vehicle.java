public class Vehicle {
    private String make;
    private String plate;
    private String color;
    private String category;

    public Vehicle(String make, String plate, String color, String category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }

    public Vehicle(String mazda, String customPlate, String white, VehicleType vehicleType, Gear gear, CarType carType) {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String toString() {
        return "Employee has a " + getClass() + "\n" +
                "Make: " + make + "\n" +
                "Plate: " + plate + "\n" +
                "Color: " + color + "\n" +
                "Category: " + category + "\n";

    }

    public void displayInfo() {
    }


}

class Car extends Vehicle {

    // Fields representing the characteristics of a Car
    private Gear gear;
    private CarType type;

    // Constructor to initialize the Car object with specific attributes
    public Car(String make, String plate, String color, VehicleType category, Gear gear, CarType type) {
        // Call the constructor of the superclass (Vehicle) to set common attributes
        super(make, plate, color, String.valueOf(category));
        // Set specific attributes of the Car
        this.gear = gear;
        this.type = type;
    }

    // Getter and setter methods
    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }


    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    // Override the toString method to provide a custom string representation of the Car
    @Override
    public String toString() {
        // Call the toString method of the superclass (Vehicle) to include common attributes
        String total = super.toString();
        // Add Car-specific information to the string representation
        total = total + "   -Gear: " + this.getGear() + "\n";
        total = total + "   -Type: " + this.getType() + "\n";
        return total;
    }
}

enum CarType {
    Sport,
    SUV,
    Hatchback,
    Minivan,
    Sedan
}
enum VehicleType {
    RACE,
    NOT_FOR_RACE,
    Family
}

enum Gear {
    Manual,
    Automatic
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String plate, String color, VehicleType race, boolean hasSidecar) {
        super(make, plate, color, "motorcycle");
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        StringBuilder motorcycleDetails = new StringBuilder(super.toString());
        motorcycleDetails.append("Motorcycle Details:\n");
        motorcycleDetails.append("Has Sidecar: ").append(hasSidecar).append("\n");
        return motorcycleDetails.toString();
    }
}

