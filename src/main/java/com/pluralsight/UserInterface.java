package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

        private Dealership dealership  ;
        private DealershipFileManager fileManager;
        private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.fileManager = fileManager;
    }

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }

    boolean running = true;
    public void displayMenu()
    {
        UserInterface userInterface = new UserInterface();
        userInterface.userInputRequest(userInterface);
    }

     public void userInputRequest(UserInterface userInterface){
        init();
        boolean running = false;
        while (!running) {
            System.out.println("Welcome to the Car Dealership!");
            System.out.println("1. Get by price request");
            System.out.println("2. Get by make model request");
            System.out.println("3. Get by year request");
            System.out.println("4. Get by color request");
            System.out.println("5. Get by mileage request");
            System.out.println("6. Get by vehicle typeRequest");
            System.out.println("7. Get all vehicles");
            System.out.println("8. add vehicles");
            System.out.println("9. remove vehicles");
            System.out.println("10. display vehicle helper");
            System.out.println("11. exit");
            System.out.println("enter your choice: ");

            int choice = scanner.nextInt();
           scanner.nextLine();
            switch (choice){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    dealership.getAllVehicles();
                    break;
                case 11:
                    running = true;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice. please try again.");
                    break;
            }
        }
        scanner.close();
    }


    private void processGetByPriceRequest(){
        System.out.println("Enter Price Range");
        System.out.println("Minimum Price Range");
        double minPrice = scanner.nextDouble();
        System.out.println("Maximum Price Range");
        double maxPrice = scanner.nextDouble();
        List<Vehicle> list = dealership.getVehiclesByPrice(minPrice, maxPrice);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Enter Make");
        String make = scanner.nextLine();
        System.out.println("Enter Model");
        String model = scanner.nextLine();
        List<Vehicle> list = dealership.getVehicleByMakeModel(make, model);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }

    }

    private void processGetByYearRequest(){
        System.out.println("Enter Year Range");
        System.out.println("From year");
        int fromYear = scanner.nextInt();
        System.out.println("To year");
        int toYear = scanner.nextInt();
        List<Vehicle> list = dealership.getVehicleByYear(fromYear, toYear);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }
    }

    private void processGetByColorRequest(){
        System.out.println("Enter Color");
        String color = scanner.nextLine();
        List<Vehicle> list = dealership.getVehicleByColor(color);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }
    }

    private  void processGetByMileageRequest(){
        System.out.println("Enter Mileage Range");
        System.out.println("Minimum Mileage");
        int minMileage = scanner.nextInt();
        System.out.println("Maximum Mileage");
        int maxMileage = scanner.nextInt();
        List<Vehicle> list = dealership.getVehicleByMileage(minMileage, maxMileage);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }
    }

    private void processGetByVehicleTypeRequest(){
        System.out.println("Enter Vehicle Type");
        String type = scanner.nextLine();
        List<Vehicle> list = dealership.getVehiclesByType(type);
        if(list == null || list.isEmpty()) {
            System.out.println("***** No vehicles available for given input *****");
        }
    }

    private void displayVehicleHelper(List<Vehicle> vehicles){
        System.out.println("Listing vehicles:");
        if(vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles available");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void processGetAllVehicleRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicleHelper(allVehicles);
    }

    private void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter VIN Number: ");
        int vin = scanner.nextInt();
        System.out.println("Please Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Please Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Please Enter vehicleType: ");
        String vehicleType = scanner.nextLine();
        System.out.println("Please Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Please Enter odometer: ");
        int odometer = scanner.nextInt();
        System.out.println("Please Enter price: ");
        double price = scanner.nextDouble();
        dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));
        saveDealership();
    }

    private void processRemoveVehicleRequest(){
        System.out.println("Please Enter VIN Number: ");
        int vin = scanner.nextInt();
        dealership.removeVehicle(vin);
        saveDealership();
        System.out.println(vin + " is removed successfully from vehicle list");
    }

    private void saveDealership(){
        DealershipFileManager.saveDealership(dealership);
    }

}







