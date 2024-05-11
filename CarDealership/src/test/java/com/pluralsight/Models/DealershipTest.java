package com.pluralsight.Models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DealershipTest {
    // universal object variables to test all methods.
    public final Vehicle vehicle1 = new Vehicle(1,2008, "BMW", "328xi", "Sedan","Red", 121222, 5000);
    public final Vehicle vehicle2 = new Vehicle(2,2010, "Toyota", "Corolla", "Sedan","Grey", 66232, 7500);
    public final Vehicle vehicle3 = new Vehicle(3,2014, "Honda", "Civic", "Sedan","Red", 80203, 5000);
    public final Vehicle vehicle4 = new Vehicle(4,2020, "Tesla", "Model Y", "SUV","Grey", 30000, 22000);
    public final Vehicle vehicle5 = new Vehicle(5,2024, "Rivian", "R1S", "SUV","Grey", 100, 98000);

    // <editor-fold desc="Search Tests">
    @Test
    public void get_Vehicles_By_Price() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByPrice(5000, 10000);

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle1, vehicle2, vehicle3);
        String message = "Price" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_Vehicles_By_MakeModel() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByMakeModel("BMW", "328xi");

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle1);
        String message = "Make-Model" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_Vehicles_By_Year() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByYear(2012, 2024);

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle3, vehicle4, vehicle5);
        String message = "Year" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_Vehicles_By_Color() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByColor("Red");

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle1, vehicle3);
        String message = "Color" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_Vehicles_By_Mileage() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByMileage(0, 70000);

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle2, vehicle4, vehicle5);
        String message = "Mileage" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_Vehicles_By_Type() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> filteredActual = dealership.getVehiclesByType("SUV");

        // assert - verify that the action worked as expected
        List<Vehicle> filteredExpected = List.of(vehicle4, vehicle5);
        String message = "Vehicle Type" + " Search Error";
        assertEquals(message, filteredExpected, filteredActual);
    }

    @Test
    public void get_All_Vehicles() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.addVehicle(vehicle4);
        dealership.addVehicle(vehicle5);

        // act --> THE ONE action that I am testing
        List<Vehicle> allActual = dealership.getAllVehicles();

        // assert - verify that the action worked as expected
        List<Vehicle> allExpected = List.of(vehicle1,vehicle2, vehicle3, vehicle4, vehicle5);
        String message = "Get All" + " Search Error";
        assertEquals(message, allExpected, allActual);
    }
    // </editor-fold>
    // <editor-fold desc="Add/Remove Test">
    @Test
    public void add_Vehicle() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");

        // act --> THE ONE action that I am testing
        dealership.addVehicle(vehicle1);

        // assert - verify that the action worked as expected
        List<Vehicle> actual = dealership.getAllVehicles();
        List<Vehicle> expected = List.of(vehicle1);
        String message = "Add Vehicle" + " Error";
        assertEquals(message, expected, actual);
    }

    @Test
    public void remove_Vehicle() {
        // arrange - setup
        Dealership dealership = new Dealership("Test Dealership", "123 Test Ave", "555-555-5555");

        // act --> THE ONE action that I am testing
        dealership.addVehicle(vehicle1);
        dealership.addVehicle(vehicle2);
        dealership.addVehicle(vehicle3);
        dealership.removeVehicle(vehicle3);

        // assert - verify that the action worked as expected
        List<Vehicle> actual = dealership.getAllVehicles();
        List<Vehicle> expected = List.of(vehicle1, vehicle2);
        String message = "Remove Vehicle" + " Error";
        assertEquals(message, expected, actual);
    }
    // </editor-fold>
}