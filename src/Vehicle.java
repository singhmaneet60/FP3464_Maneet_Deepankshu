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

    @Override
    public String toString() {
        return "Vehicle Details:\n" +
                "Make: " + make + "\n" +
                "Plate: " + plate + "\n" +
                "Color: " + color + "\n" +
                "Category: " + category + "\n";
    }

    public void displayInfo() {
    }
}

class Car extends Vehicle {
    private String carGear;
    private String carType;

    public Car(String make, String plate, String color, String carGear, String carType) {
        super(make, plate, color, "car");
        this.carGear = carGear;
        this.carType = carType;
    }

    public Car(String mazda, String customPlate, String white, VehicleType vehicleType, Gear gear, CarType carType) {
        super(mazda, customPlate, white, vehicleType, gear, carType);
    }

    public String getCarGear() {
        return carGear;
    }

    public void setCarGear(String carGear) {
        this.carGear = carGear;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        StringBuilder carDetails = new StringBuilder(super.toString());
        carDetails.append("Car Details:\n");
        carDetails.append("Car Gear: ").append(carGear).append("\n");
        carDetails.append("Car Type: ").append(carType).append("\n");
        return carDetails.toString();
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

