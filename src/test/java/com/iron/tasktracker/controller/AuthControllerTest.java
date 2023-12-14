package com.iron.tasktracker.controller;

import controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AuthControllerTest {

    @MockBean
    private AuthController authController;

    @Test
    public void testLogin() throws Exception {
        // test logic for login endpoint
    }

    @Test
    public void testSignup() throws Exception {
        // test logic for signup endpoint
    }
}
