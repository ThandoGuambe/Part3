/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mypoe;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
   //Test valid username
    @Test
    public void checkValidUsername() {
        System.out.println("checkUsername");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    }
    
    //Test Invalid username
    @Test
    public void checkInvalidUsername() {
        System.out.println("checkUsername");
        String username = "kyl!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    }

    //Test valid Password
    @Test
    public void checkValidPassword() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }
    
    //Test invalid Password
    @Test
    public void checkInvalidPassword() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    //Test user registration: invalid username
    @Test
    public void testRegisterUserInvalidUsername() {
        System.out.println("registerUser");
        String username = "kyle!!!!!!!";
        String password = "password";
        String name = "Kyle";
        String surname = "Newport";
        Login instance = new Login();
        String expResult = "Username is not correctly formatted.";
        String result = instance.registerUser(username, password, name, surname);
        assertEquals(expResult, result);
    }
    
    //Test user registration: invalid password
    @Test
    public void testRegisterUserInvalidPassword() {
        System.out.println("registerUser");
        Login instance = new Login();
        String expResult = "Username is not correctly formatted.";
        String result = instance.registerUser("user_", "password", "Kyle", "Newport");
        assertEquals("Password is not correctly formatted.", result);
    }
    
    //Test user registration: invalid password
    @Test
    public void testRegisterUserValidPasswordandUsername() {
        System.out.println("registerUser");
        Login instance = new Login();
        String expResult = "Username is not correctly formatted.";
        String result = instance.registerUser("user_", "Password1!", "Kyle", "Newport");
        assertEquals("User registered successfully!", result);
    }
}

    