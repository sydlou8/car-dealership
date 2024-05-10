package com.pluralsight.Services;

import com.pluralsight.Models.Dealership;
import com.pluralsight.Models.Vehicle;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    static final String DEALERSHIP_FILE = "dealership.csv";
    static final String DIRECTORY = "file";
    static String [] title = new String[3];
    // get
    public static Dealership getDealership() {
        File directory = new File(DIRECTORY);
        if(!directory.exists()) directory.mkdir();

        File file = new File(DIRECTORY + "/" + DEALERSHIP_FILE);
        try {
            FileInputStream fileStream = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fileStream);
            title = fileScanner.nextLine().split("\\|");
            Dealership dealership = new Dealership(title[0], title[1], title[2]);
            while(fileScanner.hasNext()) {
                String[] dealershipInfo = fileScanner.nextLine().split("\\|");
                if(dealershipInfo[0].isEmpty()) break;

                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(dealershipInfo[0]),
                        Integer.parseInt(dealershipInfo[1]),
                        dealershipInfo[2],
                        dealershipInfo[3],
                        dealershipInfo[4],
                        dealershipInfo[5],
                        Integer.parseInt(dealershipInfo[6]),
                        Double.parseDouble(dealershipInfo[7])
                );

                dealership.addVehicle(vehicle);
            }
            return dealership;
        } catch (FileNotFoundException _) {
            System.out.println("FILE ERROR");
            return null;
        }
    }
    public static void saveDealership(Dealership dealership){
        File file = new File(DIRECTORY + "/" + DEALERSHIP_FILE);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.printf("%s|%s|%s\n", title[0], title[1], title[2]);
            dealership.getAllVehicles().forEach(vehicle -> {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%4.2f\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
            });
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }
}
