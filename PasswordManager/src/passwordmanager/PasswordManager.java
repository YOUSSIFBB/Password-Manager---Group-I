/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordmanager;

public class PasswordManager {

    //Member variables
    public String name, emailAddress, password, dateOfBirth, sex;
    public String phoneNumber;
    public int id;

    // Constructor with parameters to initialize the object
    public PasswordManager(String name, String emailAddress, String password, String dateOfBirth, String sex, String phoneNumber, int id) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    // Default constructor value
    public PasswordManager() {
        name = " ";
        emailAddress = " ";
        password = " ";
        dateOfBirth = " ";
        sex = " ";
        phoneNumber = " ";
        id = 0;
    }

    //Getters and Setters 
    public int getId() {
        return id;
    }

    //Getters and Setters 
    public void setId(int id) {
        this.id = id;
    }

    //Getters and Setters 
    public void setName(String name) {
        this.name = name;
    }

    //Getters and Setters 
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    //Getters and Setters 
    public void setPassword(String password) {
        this.password = password;
    }

    //Getters and Setters 
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //Getters and Setters 
    public void setSex(String sex) {
        this.sex = sex;
    }

    //Getters and Setters 
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Getters and Setters 
    public String getName() {
        return name;
    }

    //Getters and Setters 
    public String getEmailAddress() {
        return emailAddress;
    }

    //Getters and Setters 
    public String getPassword() {
        return password;
    }

    //Getters and Setters 
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    //Getters and Setters 
    public String getSex() {
        return sex;
    }

    //Getters and Setters 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Validation methods below:
    //checks if the name is not null and not empty, and matches its rejex pattern
    public static boolean validateName(String name) {
        // Check if the name is not null and not empty
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        //using regex pattern to improve its maintainability
        String namePattern = "^[A-Za-z-' ]+$";
        // Check if the name matches the pattern
        return name.matches(namePattern);
    }

    //Validates the Email Address against its rejex pattern.
    public static boolean validateEmailAddress(String emailAddress) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
        if (!emailAddress.matches(regex)) {
            return false;
        }

        return true;
    }

    //validates irish phone numbers usuing the rejex pattern
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^(?:\\+353|0)8[35679]\\d{7}$")) {
            return false;
        }
        return true;
    }

    //validates the password based on given criteria (uppercase, lowercase, number, special character, and length)
    public static boolean validatePassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
        if (!password.matches(regex)) {
            return false;
        }
        return true;
    }

    //Validates date of birth with a specific format. 
    public static boolean validateDateOfBirth(String dateOfBirth) {
        String regex = "^(\\d{1,2}\\s+[A-Za-z]+\\s+\\d{4}|[A-Za-z]+\\s+\\d{1,2},?\\s+\\d{4})$";

        if (!dateOfBirth.matches(regex)) {
            return false;
        }
        return true;
    }

    //validates sex based on predefined options.
    public static boolean validateSexSelection(String sex) {
        // Define the valid options
        String[] validOptions = {"Male", "Female", "Bisexual", "Others"};

        // Check if the selected item is one of the valid options
        for (String validOption : validOptions) {
            if (validOption.equals(sex)) {
                return true;
            }
        }
        return false;
    }

}
