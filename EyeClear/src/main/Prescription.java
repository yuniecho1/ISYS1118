package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    private ArrayList<String> postRemarks = new ArrayList<>();
    
 // Constructor to initialize Prescription object
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, float axis, float cylinder, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }
    
    public boolean addPrescription() {
    	// Check the conditions as per the provided requirements
        if (firstName.length() >= 4 && firstName.length() <= 15 &&
            lastName.length() >= 4 && lastName.length() <= 15 &&
            address.length() >= 20 &&
            sphere >= -20.00 && sphere <= 20.00 &&
            cylinder >= -4.00 && cylinder <= 4.00 &&
            axis >= 0 && axis <= 180 &&
            optometrist.length() >= 8 && optometrist.length() <= 25) {
 
            // If conditions are met, write the prescription details to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("presc.txt", true))) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                writer.write("Prescription ID: " + prescID + "\n");
                writer.write("First Name: " + firstName + "\n");
                writer.write("Last Name: " + lastName + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Sphere: " + sphere + "\n");
                writer.write("Cylinder: " + cylinder + "\n");
                writer.write("Axis: " + axis + "\n");
                writer.write("Examination Date: " + sdf.format(examinationDate) + "\n");
                writer.write("Optometrist: " + optometrist + "\n");
                writer.write("\n");
                return true; // Information successfully added
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception
            }
        }
        return false; // If any condition is not met
    }

    public boolean addRemark(String remark, String remarkType) {
    	
    	// Check if the remark meets the conditions
        if (remark.split("\\s+").length >= 6 && remark.split("\\s+").length <= 20 &&
            Character.isUpperCase(remark.charAt(0)) &&
            (remarkType.equalsIgnoreCase("Client") || remarkType.equalsIgnoreCase("Optometrist")) &&
            postRemarks.size() < 2) {
 
            // Add remark to the postRemarks list
            postRemarks.add(remark);
 
            // Write the remark to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("remark.txt", true))) {
                writer.write("Prescription ID: " + prescID + "\n");
                writer.write("Remark: " + remark + "\n");
                writer.write("Remark Type: " + remarkType + "\n");
                writer.write("\n");
                return true; // Remark successfully added
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception
            }
        }
        return false; // If any condition is not met
    }
}