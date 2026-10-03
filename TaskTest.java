package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testTask() {
        Task task = new Task("12345", "Homework", "Complete CS 320 milestone");

        assertEquals("12345", task.getTaskId());
        assertEquals("Homework", task.getName());
        assertEquals("Complete CS 320 milestone", task.getDescription());
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Homework", "Complete assignment");
        });
    }

    @Test
    void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Homework", "Complete assignment");
        });
    }

    @Test
    void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This name is way too long", "Complete assignment");
        });
    }

    @Test
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Complete assignment");
        });
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(
                "12345",
                "Homework",
                "This description is intentionally longer than fifty characters so the test fails"
            );
        });
    }

    @Test
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Homework", null);
        });
    }

    @Test
    void testSetName() {
        Task task = new Task("12345", "Homework", "Complete assignment");

        task.setName("Study");

        assertEquals("Study", task.getName());
    }

    @Test
    void testSetDescription() {
        Task task = new Task("12345", "Homework", "Complete assignment");

        task.setDescription("Complete unit tests");

        assertEquals("Complete unit tests", task.getDescription());
    }
}