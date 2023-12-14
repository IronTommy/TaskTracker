package com.iron.tasktracker.controller;

import controller.TaskController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TaskControllerTest {

    @MockBean
    private TaskController taskController;

    @Test
    public void testGetTasks() throws Exception {
        // Your test logic for getTasks endpoint
    }

    @Test
    public void testCreateTask() throws Exception {
        // Your test logic for createTask endpoint
    }

    @Test
    public void testUpdateTask() throws Exception {
        // Your test logic for updateTask endpoint
    }

    @Test
    public void testDeleteTask() throws Exception {
        // Your test logic for deleteTask endpoint
    }
}
