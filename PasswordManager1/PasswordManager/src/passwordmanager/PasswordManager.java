/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passwordmanager;

/**
 *
 * @author fadit
 */
public class PasswordManager {

    public String name, emailAddress, password, dateOfBirth, sex;
    public String phoneNumber;
    public int id;

    public PasswordManager(String name, String emailAddress, String password, String dateOfBirth, String sex, String phoneNumber, int id) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public PasswordManager() {
        name = " ";
        emailAddress = " ";
        password = " ";
        dateOfBirth = " ";
        sex = " ";
        phoneNumber = " ";
        id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static boolean validateName(String name) {
        // Check if the name is not null and not empty
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        // Define the allowed name pattern (letters, hyphens, and apostrophes)
        String namePattern = "^[A-Za-z-' ]+$";

        // Check if the name matches the pattern
        return name.matches(namePattern);
    }

    public static boolean validateEmailAddress(String emailAddress) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
        if (!emailAddress.matches(regex)) {
            return false;
        }

        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^(?:\\+353|0)8[35679]\\d{7}$")) {
            return false;
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$";
        if (!password.matches(regex)) {
            return false;
        }
        return true;
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        String regex = "^(\\d{1,2}\\s+[A-Za-z]+\\s+\\d{4}|[A-Za-z]+\\s+\\d{1,2},?\\s+\\d{4})$";

        if (!dateOfBirth.matches(regex)) {
            return false;
        }
        return true;
    }

    public static boolean validateSexSelection(String sex) {
        // Define the valid options
        String[] validOptions = {"Male", "Female", "Bisexual", "Others"};

        // Check if the selected item is one of the valid options
        for (String validOption : validOptions) {
            if (validOption.equals(sex)) {
                return true;
            }
        }

        // If not, return false
        return false;
    }

}
