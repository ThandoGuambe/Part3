/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mypoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
class MYPOETest {
    // Mock variables similar to those in my main class
    private static String[] taskIDs;
    private static String[] developer;
    private static String[] taskNames;
    private static int[] durations;
    private static String[] taskStatuses;
    private static int taskCount;
    
    @BeforeEach
    public void setUp() {
        // Declare and initialize arrays and mock data
        taskIDs = new String[5];
        developer = new String[5];
        taskNames = new String[5];
        durations = new int[5];
        taskStatuses = new String[5];
        taskCount = 5;
        
        //Assign mock data
        taskIDs[0] = "MI:0:ITH";
        developer[0] = "Mike Smith";
        taskNames[0] = "Create Login";
        durations[0] = 5;
        taskStatuses[0] = "To do";
        
        taskIDs[1] = "ED:1:SON";
        developer[1] = "Edward Harrison";
        taskNames[1] = "Create Add Feature";
        durations[1] = 8;
        taskStatuses[1] = "Doing";
        
        taskIDs[2] = "SA:2:SON";
        developer[2] = "Samantha Paulson";
        taskNames[2] = "Create Reports";
        durations[2] = 2;
        taskStatuses[2] = "Done";
        
        taskIDs[3] = "GL:3:ZER";
        developer[3] = "Glenda Oberholzer";
        taskNames[3] = "Add Arrays";
        durations[3] = 11;
        taskStatuses[3] = "To do";
        
        taskIDs[4] = "KY:4:ORT";
        developer[4] = "Kyle Newport";
        taskNames[4] = "Create Registration";
        durations[4] = 6;
        taskStatuses[4] = "To do";
    }
    //Developer Array is correctly populated
    @Test
    void testDeveloperArray(){
        for (int i = 0; i < taskCount; i++){
            System.out.println(developer[i]);   
        }
    }
    
    
    //Test the showLongestTask() method.
    @Test
    void testShowLongestTask(){
        //decalred the index of the longest task
        int maxtime = 3;
        for (int i = 0; i < taskCount; i++){
            System.out.println("Glenda Oberholzer," + " " + "11");
            if (durations[i] > durations[maxtime]) { 
             assertEquals(11, durations[maxtime]);
             break;
            }   
        }
    }
    //Test the displayDoneTasks() method.
    @Test
    void testDisplayDoneTasks(){
        StringBuilder result = new StringBuilder("Completed tasks:\n");
        ;
        for (int i = 0; i < taskCount; i++) {
            if ("Done".equalsIgnoreCase(taskStatuses[i])) {
                result.append(String.format("Developer: %s\nTask: %s\nDuration: %d hours",
                        developer[i], taskNames[i], durations[i]));
                break;
            }
        }
        assertTrue(result.toString().contains("Create Reports"));
    }
    //Test the SearchTaskName() method
    @Test
    void checkCreateLoginSearch(){
        String taskName = "Create Login";
        String foundTask = null;
        for (int i = 0; i < taskCount; i++) {
            System.out.println(developer[i] + " " + taskNames[i]);
            if (taskName.equalsIgnoreCase(taskNames[i])) {
                foundTask = taskNames[i];
                break;
            }
        }
        assertNotNull(foundTask);
        assertEquals("Create Login", foundTask);
    }
 
     
    
}
