import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

    @Test
    void testAddAppointment() {

        AppointmentService service = new AppointmentService();

        Date futureDate =
                new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment =
                new Appointment(
                        "12345",
                        futureDate,
                        "Doctor appointment");

        service.addAppointment(appointment);

        assertEquals(
                appointment,
                service.getAppointment("12345"));
    }

    @Test
    void testAddDuplicateAppointment() {

        AppointmentService service = new AppointmentService();

        Date futureDate =
                new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment1 =
                new Appointment(
                        "12345",
                        futureDate,
                        "Doctor appointment");

        Appointment appointment2 =
                new Appointment(
                        "12345",
                        futureDate,
                        "Dentist appointment");

        service.addAppointment(appointment1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    void testDeleteAppointment() {

        AppointmentService service = new AppointmentService();

        Date futureDate =
                new Date(System.currentTimeMillis() + 86400000);

        Appointment appointment =
                new Appointment(
                        "12345",
                        futureDate,
                        "Doctor appointment");

        service.addAppointment(appointment);

        service.deleteAppointment("12345");

        assertNull(service.getAppointment("12345"));
    }

    @Test
    void testDeleteAppointmentNotFound() {

        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
    }
}