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
        System.out.println("7. exit");
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

    public void display(){
        System.out.println("welcome!");
        System.out.println("1. Get all vehicles");
        System.out.println("2. Add a vehicles");
        System.out.println("3. Remove a vehicles");
        System.out.println("4. display vehicle helper");
        System.out.println("5. exits");
        System.out.println("enter your choice:");
    }
    public void handleUserInput(){
        boolean exit = false;
        while (!exit){
            display();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    processGetAllVehicleRequest();
                    break;
                case 2:
                    processAddVehicleRequest();
                    break;
                case 3:
                    processRemoveVehicleRequest();
                    break;
                case 4:
                    displayVehicleHelper();
                    break;
                case 5:
                    exit = true;
                    saveDealership();
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice please try again.");
                    break;
            }
        }
    }



    private void displayVehicleHelper(List<Vehicle> vehicles){
        System.out.println("Listing vehicles:");
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        }

       private void processGetAllVehicleRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicleHelper(allVehicles);
        }

        private void processAddVehicleRequest(){
        dealership.addVehicle();
         saveDealership();
        }

        private void processRemoveVehicleRequest(){
        dealership.removeVehicle();
        saveDealership();
        }

        private void saveDealership(){
        DealershipFileManager.saveDealership(dealership);
        }

    }

