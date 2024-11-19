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
    
    public static void main(String[] args) {
        
        // Create an instance of the Login class for user authentication
        Login loginSystem = new Login();
        
        // Variable declarations for user details
        String username;
        String password;
        String name;
        String surname;
        String loginUsername;
        String loginPassword;
        boolean LoggedIn = false;

        // Prompt user for their first and last name
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
                    "2) Show Report (Coming Soon)\n" +
                    "3) Quit");
                
                // Parse the user's menu selection
                int option = Integer.parseInt(menu);

                // Handle menu options using a switch statement
                switch (option) {
                    case 1:
                        // Allow the user to create new tasks
                        addTasks();
                        break;
                    case 2:
                        // Display a placeholder for the report feature
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 3:
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
            Task task = new Task(taskName, i, description, developerDetails, duration, taskStatus);
            taskList.add(task);
            totalHrs += duration;

            // Display task details
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        // Display the total hours for all tasks
        JOptionPane.showMessageDialog(null, "Total task hours: " + totalHrs);
    }
}
