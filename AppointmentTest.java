import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentTest {

    @Test
    void testAppointment() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment =
                new Appointment("12345", futureDate, "Doctor appointment");

        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    @Test
    void testAppointmentIdTooLong() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Doctor appointment");
        });
    }

    @Test
    void testAppointmentIdNull() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Doctor appointment");
        });
    }

    @Test
    void testAppointmentDateInPast() {

        Date pastDate = new Date(System.currentTimeMillis() - 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Doctor appointment");
        });
    }

    @Test
    void testAppointmentDateNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Doctor appointment");
        });
    }

    @Test
    void testDescriptionTooLong() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(
                    "12345",
                    futureDate,
                    "This description is more than fifty characters long and is invalid.");
        });
    }

    @Test
    void testDescriptionNull() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
    }

    @Test
    void testSetAppointmentDate() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment =
                new Appointment("12345", futureDate, "Doctor appointment");

        Date newFutureDate =
                new Date(System.currentTimeMillis() + 172800000);

        appointment.setAppointmentDate(newFutureDate);

        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    @Test
    void testSetDescription() {

        Date futureDate = new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment =
                new Appointment("12345", futureDate, "Doctor appointment");

        appointment.setDescription("Dentist appointment");

        assertEquals("Dentist appointment", appointment.getDescription());
    }
}