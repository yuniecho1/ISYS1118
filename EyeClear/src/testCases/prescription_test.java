package testCases;

import main.Prescription;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

class testCase1 {

    Prescription prescription;
    Date examDate;

    @BeforeEach
    void setUp() {
        // Setup before each test case
        examDate = new Date();
        prescription = new Prescription(1, "John", "Smith", "123 Long Street, City, 56789, Country", 1.50f, 90.00f, 2.00f, examDate, "Dr. Johnson");
    }

    // Test Cases for addPrescription

    @Test
    void testPrescriptionValid() {
        // Test a valid prescription
        assertTrue(prescription.addPrescription(), "Valid prescription should be added successfully.");
    }

    @Test
    void testInvalidFirstName() {
        // First name less than 4 characters
        Prescription invalidPrescription = new Prescription(2, "Jon", "Smith", "123 Long Street, City, 56789, Country", 1.50f, 90.00f, 2.00f, examDate, "Dr. Johnson");
        assertFalse(invalidPrescription.addPrescription(), "Prescription should fail due to invalid first name (less than 4 characters).");
    }

    @Test
    void testInvalidLastName() {
        // Last name less than 4 characters
        Prescription invalidPrescription = new Prescription(3, "John", "Smi", "123 Long Street, City, 56789, Country", 1.50f, 90.00f, 2.00f, examDate, "Dr. Johnson");
        assertFalse(invalidPrescription.addPrescription(), "Prescription should fail due to invalid last name (less than 4 characters).");
    }

    @Test
    void testInvalidAddress() {
        // Address less than 20 characters
        Prescription invalidPrescription = new Prescription(4, "John", "Smith", "Short St", 1.50f, 90.00f, 2.00f, examDate, "Dr. Johnson");
        assertFalse(invalidPrescription.addPrescription(), "Prescription should fail due to invalid address (less than 20 characters).");
    }

    @Test
    void testInvalidSphereValue() {
        // Sphere value out of valid range
        Prescription invalidPrescription = new Prescription(5, "John", "Smith", "123 Long Street, City, 56789, Country", 21.00f, 90.00f, 2.00f, examDate, "Dr. Johnson");
        assertFalse(invalidPrescription.addPrescription(), "Prescription should fail due to sphere value out of range (-20.00 to 20.00).");
    }

    @Test
    void testInvalidAxisValue() {
        // Axis value out of valid range (0 to 180)
        Prescription invalidPrescription = new Prescription(6, "John", "Smith", "123 Long Street, City, 56789, Country", 1.50f, 190.00f, 2.00f, examDate, "Dr. Johnson");
        assertFalse(invalidPrescription.addPrescription(), "Prescription should fail due to axis value out of range (0 to 180).");
    }
}
