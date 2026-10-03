package task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete assignment");

        service.addTask(task);

        assertEquals(task, service.getTask("12345"));
    }

    @Test
    void testAddDuplicateTask() {
        TaskService service = new TaskService();

        Task task1 = new Task("12345", "Homework", "Complete assignment");
        Task task2 = new Task("12345", "Study", "Study for exam");

        service.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete assignment");

        service.addTask(task);
        service.deleteTask("12345");

        assertNull(service.getTask("12345"));
    }

    @Test
    void testDeleteTaskNotFound() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("12345");
        });
    }

    @Test
    void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete assignment");

        service.addTask(task);
        service.updateTaskName("12345", "Study");

        assertEquals("Study", service.getTask("12345").getName());
    }

    @Test
    void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Homework", "Complete assignment");

        service.addTask(task);
        service.updateTaskDescription("12345", "Complete CS 320 milestone");

        assertEquals(
            "Complete CS 320 milestone",
            service.getTask("12345").getDescription()
        );
    }

    @Test
    void testUpdateNameInvalidTask() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("99999", "Study");
        });
    }

    @Test
    void testUpdateDescriptionInvalidTask() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("99999", "New description");
        });
    }
}