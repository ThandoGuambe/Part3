/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mypoe;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
// Declarations for the attributes of the Task class.
    private String taskName;         // Name of the task.
    private int taskNum;             // Unique number associated with the task.
    private String description;      // Description of the task (maximum length of 50 characters).
    private String developerDetails; // Name or details of the developer assigned to the task.
    private int duration;            // Estimated duration to complete the task (in hours).
    private String taskStatus;       // Current status of the task (e.g., "To Do", "In Progress", "Done").
    private String taskID;           // Unique ID for the task, generated automatically.
    
    public Task(String taskName, int namTasks , String description, String developerDetails, int duration, String taskStatus) {
      this.taskName = taskName;
        this.taskNum = taskNum;
        this.description = description;
        this.developerDetails = developerDetails;
        this.duration = duration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID(); // Generate a unique task ID upon creation.
    }
    // Validates if the task description is within the allowed length (<= 50 characters).
    public boolean checkTaskDescription() {
        return this.description.length() <= 50;
    }

    // Generates a unique Task ID in the format: [First 2 letters of taskName]:[taskNum]:[Last 3 letters of developerDetails]
    public String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNum + ":" +
                developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskID;
    }

    // Returns a formatted string containing all the details of the task.
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + taskNum + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + description + "\n" +
                "Task ID: " + taskID + "\n" +
                "Task Duration: " + duration + " hours";
    }

    // Returns the total duration (in hours) required for the task.
    public int returnTotalHours() {
        return duration;    
    }
}

