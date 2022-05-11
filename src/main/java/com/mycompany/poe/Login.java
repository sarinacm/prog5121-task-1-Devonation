package com.mycompany.poe;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Login {

    private String username, password, firstname, lastname, logUsername, logPassword;
    private boolean usernameTested;

    //setter methods to give the local private variables values;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    public boolean checkUserName() {//check if the username is correctly formatted;
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity() {//check if the password is correctly formatted;
//https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
        String pattern1 = ".*[A-Z].*";
        String pattern2 = ".*[0-9].*";
        String pattern3 = ".*[ ,!,#,$,%,&,',(,),*,+,,,-,.,/,:,;,<,=,>,?,@,[,],^,`,{,|,}].*";

        return password.length() >= 8 && Pattern.compile(pattern1).matcher(password).matches() && Pattern.compile(pattern2).matcher(password).matches() && Pattern.compile(pattern3).matcher(password).matches();
    }

    public String registerUser() {//display the necessary message for registration;
        if (usernameTested == false) {
            if (checkUserName() == false) {
                return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
            } else {
                usernameTested = true;
                return "Username successfully captured";
            }
        }

        if (checkPasswordComplexity() == false) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            return "Password successfully captured. Registration successful.";
        }
    }

    public boolean loginUser() {//check if the login details entered match the registration details;
        return logUsername.equals(username) && logPassword.equals(password);
    }

    public String returnLoginStatus() {//display the necessary message for loging in;
        if (loginUser()) {
            return "Login Successful. Welcome " + firstname + ", " + lastname + " it is great to see you.";
        } else {
            return "Login Failed. Username or password incorrect, please try again";
        }
    }

    public void inputFandLname() {//requesting user input for firstname and lastname;
        firstname = JOptionPane.showInputDialog(null, "What is your firstname?", "Register", 3);
        lastname = JOptionPane.showInputDialog(null, "What is your lastname?", "Register", 3);
    }

    public void inputAndValidation() {//requesting and validating user input for username and password;
        while (true) {
            username = JOptionPane.showInputDialog(null, "What is your username?", "Register", 3);
            JOptionPane.showMessageDialog(null, registerUser());
            if (checkUserName() == false) {
                break;
            }

            password = JOptionPane.showInputDialog(null, "What is your password?", "Register", 3);
            JOptionPane.showMessageDialog(null, registerUser());
            if (checkPasswordComplexity() == false) {
                break;
            }

            loginInput();
            break;
        }
    }

    public void loginInput() {//requesting and validating user input for login details;
        for (int i = 1; i >= 0; i--) {
            logUsername = JOptionPane.showInputDialog(null, "What is your username?", "Login", 3);
            logPassword = JOptionPane.showInputDialog(null, "What is your password?", "Login", 3);

            JOptionPane.showMessageDialog(null, returnLoginStatus());
            if (loginUser() == true) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "You have " + i + " more attempt(s).");
            }
        }
    }
}
