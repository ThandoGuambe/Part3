/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mypoe;
import java.util.regex.Pattern;
import java.util.regex.*;
/**
 *
 * @author RC_Student_lab
 */
class Login {
   // Declare private variables to store user details
    private String name;
    private String surname;
    private String username;
    private String password;
    
    //Validate the format and requirements of the username, that being the username be no longer than 5 characters long and contains an underscore.
    public boolean checkUsername(String username) {
        boolean Found = false;
        if(username.contains("_") && username.length() <=5){
        Found = true;
        System.out.println("Username successfully captured.");
        return true;
        }else{
            Found = false;
            System.out.println("Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length.");
            return false;
        }
    }
    //Verify the complexity of the password based on a set of criteria (At least 8 charcters long, with captial letter, number and special character)
    public boolean checkPasswordComplexity(String password){
     //Define Regular expression pattern for validation
     Pattern check_num = Pattern.compile("[0123456789]");
     Pattern check_uppercase = Pattern.compile("[QWERTYUIOPLKJHGFDSAZXCVBNM]");
     Pattern check_specials = Pattern.compile("[!@#$%^&*+-_:.<,>~']");
     
     //Declare and assign a temporary variable to false.
     boolean Found = false;
     
     if(check_num.matcher(password).find() && (check_specials.matcher(password).find()) && (check_uppercase.matcher(password).find())){
         Found = true;
         System.out.println("Password successfully captured.");
         //Assign the temporary variable to true if the password is captured successfully.
         return true;
     }else{
        //Assign the temporary variable to false if the password is not captured successfully.
         Found = false;
         System.out.println("Password is not correctly formatted, please "
                 + "ensure that the password contains at least 8 characters, a "
                 + "capital letter, a number and a special character.");
         return Found;
     }
    }
    //Register a user new user to the system
    public String registerUser(String username,String password, String name,String surname) {
        //Confirm if the username meets the validation requirements
        if(!checkUsername(username)){
            return "Username is not correctly formatted.";
        } else if(!checkPasswordComplexity(password)){
        //Confirm if the password meets the complexity requirements.
            return "Password is not correctly formatted.";
        } else{
            this.name = name;
            this.surname = surname;
            this.username = username;
            this.password = password;
            return "User registered successfully!";
        }  
     }
        // Verify user login credentials
        public Boolean loginUser(String username, String password) {
        // Check if the entered username and password match the stored ones
        return this.username.equals(username) && this.password.equals(password);
        }
        //Return the status of the login attempt.
        public String LoginStatus(String username, String password, String name, String surname) {
        if (loginUser(username, password)) {
            return "Welcome " + name + " " + surname + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}   
