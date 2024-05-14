package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

        private Dealership dealership  ;
        private Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
        init();

    }

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();

    }

    public void displayMenu(){
        System.out.println("Welcome to the Car Dealership!");
        System.out.println("1. Get by price request");
        System.out.println("2. Get by make model request");
        System.out.println("3. Get by year request");
        System.out.println("4. Get by color request");
        System.out.println("5. Get by mileage request");
        System.out.println("6. Get by vehicle typeRequest");
        System.out.println("7. Get all vehicles request");
        System.out.println("8.add vehicle request");
        System.out.println("9. remove vehicle request");
        System.out.println("10. helper vehicle ");
        System.out.println("11. exit");
        System.out.println("enter your choice: ");

    }

     public void userInputRequest(){
        boolean exit = false;
        while (!exit){
            displayMenu();
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
                    processGetByAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                case 10:
                    displayVehicleHelper();
                    break;

                case 11:
                    exit = true;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice. please try again.");
                    break;
            }
        }
    }


    private void processGetByPriceRequest(){

    }

    private void processGetByMakeModelRequest(){

    }

    private void processGetByYearRequest(){

    }

    private void processGetByColorRequest(){

    }

    private  void processGetByMileageRequest(){

    }

    private void processGetByVehicleTypeRequest(){

    }

    private void processGetByAllVehiclesRequest(){

    }

    private void processAddVehicleRequest(){

    }
    private void processRemoveVehicleRequest(){

    }

    private void displayVehicleHelper(List<Vehicle> vehicles){
        System.out.println("Listing vehicles:");
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        }

       private void processGetAllVehicleRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicleHelper();
        }

    }

