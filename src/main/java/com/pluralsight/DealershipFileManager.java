package com.pluralsight;



import java.io.*;


public class DealershipFileManager {
    private String fileName;

    public DealershipFileManager() {
        this.fileName = fileName;

    }

    // method should read dealership data from file and create a dealership object
     public  Dealership getDealership() {

         Dealership dealership = null;
         try {

             BufferedReader bufferedReader = new BufferedReader(new FileReader("dealership.csv"));

             String line;
             if ((line = bufferedReader.readLine()) != null) {
                 String[] part = line.split("\\|");
                 String name = part[0];
                 String address = part[1];
                 String phone = part[2];
                 dealership = new Dealership(name, address, phone);

                 // read vehicle data and add vehicle to the dealership

                 while ((line = bufferedReader.readLine()) != null) {
                     String[] parts = line.split("\\|");
                     if (parts.length == 8) {
                         int vin = Integer.parseInt(parts[0]);
                         int year = Integer.parseInt(parts[1]);
                         String make = parts[2];
                         String model = parts[3];
                         String vehicleType = parts[4];
                         String color = parts[5];
                         int odometer = Integer.parseInt(parts[6]);
                         double price = Double.parseDouble(parts[7]);
                         dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));

                     }

                 }
             }

             bufferedReader.close();

         } catch (Exception e) {
             e.printStackTrace();

         }
         return dealership;
     }

    // saveDealerShip method

    public void saveDealership(Dealership dealership) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv")) {
                writer.write(dealership.getName()+"|"+dealership.getAddres()+"|"+dealership.getPhone());
                writer.newLine();
                for (Vehicle vehicle :dealership.getVehicle()){
                    writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                    writer.newLine();

                }
                System.out.println("Dealership data saves successfully!";)

            } catch(IOException e){
               e.printStackTrace();
                System.out.println("error occurred while saving dealership data.");

            }
        }

    }

