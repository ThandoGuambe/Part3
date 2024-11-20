/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mypoe;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author RC_Student_lab
 */
public class MYPOE {

    // List to store tasks and track total task duration
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int totalTaskDuration = 0;
    
    // Arrays to store task details
    private static String[] developer = new String[4];
    private static String[] taskNames = new String [4];
    private static String[] taskIDs = new String[4];
    private static int[] durations = new int[4];
    private static String[] taskStatuses = new String[4];
     private static int taskCount = 0;
    
    public static void main(String[] args) {
        
        // Create an instance of the Login class for user authentication.
        Login loginSystem = new Login();
        
        // Variable declarations for user details.
        String username;
        String password;
        String name;
        String surname;
        String loginUsername;
        String loginPassword;
        boolean LoggedIn = false;

        // Prompt user for their first and last name.
        name = JOptionPane.showInputDialog("Enter First Name: ");
        surname = JOptionPane.showInputDialog("Enter Last Name: ");

        // Prompt user to register an account by entering a username and password
        username = JOptionPane.showInputDialog("Register Account\nEnter Username: ");
        password = JOptionPane.showInputDialog("Enter Password: ");

        // Register the user and display the registration status
        String registration = loginSystem.registerUser(username, password, name, surname);
        JOptionPane.showMessageDialog(null, registration);

        // If registration is successful, prompt the user to log in
        if (registration.equals("User registered successfully!")) {
            loginUsername = JOptionPane.showInputDialog("Login to your account\nEnter username: ");
            loginPassword = JOptionPane.showInputDialog("Enter password: ");

            // Verify login credentials and display the login status
            String loginStatus = loginSystem.LoginStatus(loginUsername, loginPassword, name, surname);
            JOptionPane.showMessageDialog(null, loginStatus);

            // Check if login was successful
            if (loginStatus.equals("Welcome " + name + " " + surname + ", it is great to see you again.")) {
                LoggedIn = true;
            }
        }

        // If the user is logged in, display the EasyKanban menu
        if (LoggedIn) {
            
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            boolean running = true;
            while (running) {
                // Display menu options
                String menu = JOptionPane.showInputDialog(
                    "Please select an option:\n" +
                    "1) Add Tasks\n" +
                    "2) Display Report\n" +
                    "3) Display 'Done' Tasks\n" +
                    "4) Display Longest Task\n" +
                    "5) Search Task\n" +
                    "6) Search Developer\n" +
                    "7) Delete Task" +
                    "8) Quit");
                
                // Parse the user's menu selection
                int option = Integer.parseInt(menu);

                // Handle menu options using a switch statement
                switch (option) {
                    case 1:
                        // Allow the user to create new tasks
                        addTasks();
                        break;
                    case 2:
                        // Display a report that lists full details of all captured tasks.
                        report();
                        break;
                    case 3:
                        // Display the developer, task Names and Task duration of all tasks with the status of "Done"
                        for (int i = 0; i < taskCount;i++ ){
                            displayDoneTasks();
                        }
                        break;
                    case 4:
                        // Display the developer and duration of the task with the longest duration
                        showLongestTask();
                        break;
                    case 5:
                        // Search for a task with a task name and display the task name, developer and task status
                        searchTaskName();
                        break;
                    case 6:
                        // Search for all tasks assigned to a developer and display the task name and task status
                         searchDeveloper();
                        break;
                    case 7:
                        // Delete a task using task name 
                        deleteTask();
                        break;                                   
                    case 8:
                        // Exit the application
                        running = false;
                        break;
                    default:
                        // Handle invalid menu options
                        JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
                }
            }
        }

        // Display end message when the program exits
        JOptionPane.showMessageDialog(null, "__________________END______________________");
    }

    // Method to create and add tasks
    private static void addTasks() {
        // Prompt the user for the number of tasks to add
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        ArrayList<Task> taskList = new ArrayList<>();
        int totalHrs = 0;

        // Loop to collect details for each task
        for (int i = 0; i < numTasks; i++) {
            // Prompt for task name
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            
            // Validate and capture the task description
            String description;
            do {
                description = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (description.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                } else {
                    JOptionPane.showMessageDialog(null, "Task successfully captured");
                    break;
                }
            } while (description.length() > 50);

            // Prompt for developer's name
            String developerDetails = JOptionPane.showInputDialog("Enter Developer Name:");
            
            // Prompt for task duration
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));

            // Task status selection menu
            String[] statusOptions = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status",
                    "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

            
            
            // Create a new Task object and add it to the list
            Task task = new Task(taskName, i+1, description, developerDetails, duration, taskStatus);
            taskList.add(task);
            totalHrs += duration;

            developer[taskCount] = developerDetails;
            taskNames[taskCount] = taskName;
            durations[taskCount] = duration;
            taskStatuses[taskCount] = taskStatus;
            taskIDs[taskCount] = task.createTaskID();
            
            taskCount++;
            
            // Display task details
            JOptionPane.showMessageDialog(null, task.printTaskDetails());      
        }
        // Display the total hours for all tasks
        JOptionPane.showMessageDialog(null, "Total task hours: " + totalHrs);
    }
    // Method that creates a report summarizing all tasks and displays it in a dialog box
    private static void report(){
        StringBuilder report = new StringBuilder("All Tasks:\n");
        
        // Iterate through all tasks and append their details to the report
          for (int i = 0; i < taskCount; i++) {
            report.append(String.format("Task ID: %s, Developer: %s, Task: %s, Duration: %d hours, Status: %s\n",
                    taskIDs[i], developer[i], taskNames[i], durations[i], taskStatuses[i]));
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
    
    
    }
    

