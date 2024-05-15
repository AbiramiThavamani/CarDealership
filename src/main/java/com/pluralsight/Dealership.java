package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehicleByYear(int minYear, int maxYear){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getColor().equalsIgnoreCase(color)) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehicleByMileage(int minMileage, int maxMileage){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(Vehicle vehicle: vehicles) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicleList.add(vehicle);
                System.out.println(vehicle);
            }
        }
        return vehicleList;
    }

    // get all vehicle method
    public List<Vehicle> getAllVehicles(){
        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle);
        }
        return vehicles;
    }

     // add vehicle method
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

     // remove vehicle method
    public void removeVehicle(int vin){
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle: vehicles) {
            if(vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        vehicles.remove(vehicleToRemove);
    }
}