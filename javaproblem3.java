/*Problem-3
Build a validation framework that:
Validates username, age, and email
Throws custom exceptions for invalid data
Differentiates checked vs unchecked exceptions
Logs validation completion
Must Use
✔ Checked exceptions
✔ Unchecked exceptions
✔ try-catch-finally
✔ throw vs throws
✔ Custom exception classes*/

import java.util.*;
import java.io.*;
import java.util.logging.*;
class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}
public class javaproblem3 {
    static void validateusername(String username) throws InvalidUsernameException {
    if (username == null || username.length() < 5) {
        throw new InvalidUsernameException("Username must be at least 5 characters long.");
    }
}
static void validateage(int age)  {
    if (age < 18 || age > 100) {
        throw new InvalidAgeException("Age must be between 18 and 100.");
    }
}
static void validateemail(String email) throws InvalidEmailException {
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    if (email == null || !email.matches(emailRegex)) {
        throw new InvalidEmailException("Invalid email format.");
    }
}
    public static void main(String args[]){
        Logger logger= Logger.getLogger("Validation logger");
        try{
            validateusername("user");
        }catch(InvalidUsernameException e){
            System.out.println("Username validation failed: "+e.getMessage());
        }
        try{
            validateage(15);
        }
        catch(InvalidAgeException e){
            System.out.println("Age validation failed: "+e.getMessage());
        }
        try{
            validateemail("invalidemail.com");
    }
        catch(InvalidEmailException e){
            System.out.println("Email validation failed: "+e.getMessage());
        }finally{
            logger.info("Validation process completed.");
        }
    }
}
