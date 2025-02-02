class Vehicle {
    private String brand;
    private String type;
    private int manufactureYear;

    public Vehicle(String brand, String type, int manufactureYear) {
        this.brand = brand;
        this.type = type;
        this.manufactureYear = manufactureYear;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getManufactureYear() { return manufactureYear; }
    public void setManufactureYear(int manufactureYear) { this.manufactureYear = manufactureYear; }

    public void ignite() {
        System.out.println("The " + brand + " " + type + " has been ignited.");
    }
}

class ElectricVehicle extends Vehicle {
    private int powerCapacity;

    public ElectricVehicle(String brand, String type, int manufactureYear, int powerCapacity) {
        super(brand, type, manufactureYear);
        this.powerCapacity = powerCapacity;
    }

    public void recharge() {
        System.out.println("The " + getBrand() + " " + getType() + " is recharging.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("Honda", "Civic", 2021),
            new ElectricVehicle("Nissan", "Leaf", 2024, 350)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.ignite();
        }
    }
}
