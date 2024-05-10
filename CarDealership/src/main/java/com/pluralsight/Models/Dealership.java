package com.pluralsight.Models;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    // <editor-fold desc="Get Vehicles Methods">
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min)
                .filter(vehicle -> vehicle.getPrice() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make))
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(model))
                .toList();
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min)
                .filter(vehicle -> vehicle.getPrice() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .toList();
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min)
                .filter(vehicle -> vehicle.getPrice() <= max)
                .toList();
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                .toList();
    }
    public List<Vehicle> getAllVehicles() {
        return inventory.stream().toList();
    }
    // </editor-fold>
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
