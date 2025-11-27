package lab6;

import java.util.ArrayList;

interface CarbonFootprint {
    double getCarbonFootprint();
}

class Building implements CarbonFootprint {
    private String name;
    private double electricityUsed;
    private double gasUsed;

    public Building(String name, double electricityUsed, double gasUsed) {
        this.name = name;
        this.electricityUsed = electricityUsed;
        this.gasUsed = gasUsed;
    }

    public String getName() { return name; }

    public double getCarbonFootprint() {
        return electricityUsed * 0.000233 + gasUsed * 2.0;
    }
}

class Car implements CarbonFootprint {
    private String brand;
    private double fuelUsed;

    public Car(String brand, double fuelUsed) {
        this.brand = brand;
        this.fuelUsed = fuelUsed;
    }

    public String getBrand() { return brand; }

    public double getCarbonFootprint() {
        return fuelUsed * 2.31;
    }
}

class Airplane implements CarbonFootprint {
    private String planeName;
    private double distanceInKilometers;
    private double emissionFactorPerKilometer;
    private int numberOfPassengers;

    public Airplane(String planeName, double distanceInKilometers, double emissionFactorPerKilometer, int numberOfPassengers) {
        this.planeName = planeName;
        this.distanceInKilometers = distanceInKilometers;
        this.emissionFactorPerKilometer = emissionFactorPerKilometer;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getPlaneName() { return planeName; }

    public double getCarbonFootprint() {
        return (emissionFactorPerKilometer * distanceInKilometers) / numberOfPassengers;
    }
}

public class lab62 {
    public static void main(String[] args) {
        Building building = new Building("Office Tower", 50000, 2000);
        Car car = new Car("Toyota Corolla", 1200);
        Airplane airplane = new Airplane("Boeing 737", 1500, 0.25, 150);

        ArrayList<CarbonFootprint> list = new ArrayList<>();
        list.add(building);
        list.add(car);
        list.add(airplane);

        for (CarbonFootprint item : list) {
            if (item instanceof Building) {
                Building b = (Building) item;
                System.out.println("Building: " + b.getName() + ", Carbon Footprint: " + b.getCarbonFootprint());
            } else if (item instanceof Car) {
                Car c = (Car) item;
                System.out.println("Car: " + c.getBrand() + ", Carbon Footprint: " + c.getCarbonFootprint());
            } else if (item instanceof Airplane) {
                Airplane a = (Airplane) item;
                System.out.println("Airplane: " + a.getPlaneName() + ", Carbon Footprint per passenger: " + a.getCarbonFootprint());
            }
        }
    }
}

