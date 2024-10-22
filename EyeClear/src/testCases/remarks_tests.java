package testCases;

import main.Prescription;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

class remarks_tests {
	Prescription prescription;
    Date examDate;

	@Test
    void testValidRemark() {
        // Add valid remark
        assertTrue(prescription.addRemark("This client is happy with the service.", "Client"), "Valid remark should be added successfully.");
    }

    @Test
    void testRemarkTooShort() {
        // Remark with less than 6 words
        assertFalse(prescription.addRemark("Too short remark", "Client"), "Remark should fail due to having less than 6 words.");
    }

    @Test
    void testInvalidRemarkType() {
        // Invalid remark type (not "Client" or "Optometrist")
        assertFalse(prescription.addRemark("This is a valid remark with enough words.", "InvalidType"), "Remark should fail due to invalid remark type.");
    }

    @Test
    void testThirdRemarkFails() {
        // Add two valid remarks, then try adding a third
        prescription.addRemark("This client is happy with the service.", "Client");
        prescription.addRemark("Optometrist advised to check yearly.", "Optometrist");
        assertFalse(prescription.addRemark("Third remark should fail.", "Client"), "Third remark should fail due to remark limit.");
    }

    @Test
    void testRemarkWithInvalidStart() {
        // Remark does not start with an uppercase letter
        assertFalse(prescription.addRemark("this should start with an uppercase letter.", "Client"), "Remark should fail due to invalid start (not an uppercase letter).");
    }

    @Test
    void testValidOptometristRemark() {
        // Add valid remark from Optometrist
        assertTrue(prescription.addRemark("Optometrist advised a follow-up after six months.", "Optometrist"), "Valid Optometrist remark should be added successfully.");
    }

}
