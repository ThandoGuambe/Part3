/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mypoe;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    
    
    // Test for Valid Task Description
    @Test
    public void testValidTaskDescription() {
        System.out.println("Task successfully captured");
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription(), "Task successfully captured");
    }
    
    // Test for Invalid Task Description
    @Test
    public void testInvalidTaskDescription() {
        System.out.println("Please enter a task description of less than 50 characters.");
        Task task = new Task("Login Feature", 1, "Create a Login feature that will be tasked to authenticate users.", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription(), "Please enter a task description of less than 50 characters.");
    }

    // Test for Task ID creation for test Data 1.
   @Test
    public void testCreateTaskID() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:1:SON", task.createTaskID());
    }

    // Test for Task ID creation for test Data 2
   @Test
    public void testCreateTaskID2() {
        Task task = new Task("Add Task Feature", 2, "Create add task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:2:ITH", task.createTaskID());
    }
    
    //Testing the printTaskDetails() method with Test Data 1
    @Test
    public void testPrintTask1Details() {
        Task task = new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        String expectedDetails = "Task Status: To Do\n" +
                "Developer Details: Robyn Harrison\n" +
                "Task Number: 1\n" +
                "Task Name: Login Feature\n" +
                "Task Description: Create Login to authenticate users\n" +
                "Task ID: LO:1:SON\n" +
                "Task Duration: 8 hours";
        assertEquals(expectedDetails, task.printTaskDetails());
    }
    
    //Testing the printTaskDetails() method with Test Data 2
    @Test
    public void testPrintTask2Details() {
        Task task = new Task("Add Task Feature", 2, "Create add task feature to add task users", "Mike Smith", 10, "Doing");
        String expectedDetails = "Task Status: Doing\n" +
                "Developer Details: Mike Smith\n" +
                "Task Number: 2\n" +
                "Task Name: Add Task Feature\n" +
                "Task Description: Create add task feature to add task users\n" +
                "Task ID: AD:2:ITH\n" +
                "Task Duration: 10 hours";
        assertEquals(expectedDetails, task.printTaskDetails());
    }
    // Test for total hours accumulated.
    @Test
    void testReturnTotalHours() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Login Feature", 1, "Create Login to authenticate users", "Robyn Harrison", 8, "To do"));
        tasks.add(new Task("Add Task Feature", 2, "Create add task feature to add task users", "Mike Smith", 10, "Doing"));
        int totalHours = tasks.stream().mapToInt(Task::returnTotalHours).sum();
        assertEquals(18, totalHours, "Total hours aacumulated is 18.");
        }
    
    
}
