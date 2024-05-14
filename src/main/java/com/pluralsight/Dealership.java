package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

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
        return  null; // remove later
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehicleByYear(double min, double max){
        return null;
    }

    public List<Vehicle> getVehicleByColor(String color){
        return null;
    }

    public List<Vehicle> getVehicleByMileage(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return null;
    }


     // add vehicle method
    public void addVehicle(Vehicle vehicle){
        vehicle.add(vehicle);


    }
     // remove vehicle method
    public void removeVehicle(Vehicle vehicle){
        vehicle.remove(vehicle);

    }

    //method search for vehicle by make model
    public ArrayList<Vehicle> searchVehicle(String make, String model){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles){
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }


    }

