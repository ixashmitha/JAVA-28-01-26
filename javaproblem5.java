/*PROBLEM-5
Write a Java program that reads student details from a text file, processes the data, and writes the results to another file.
 
Each line in the input file contains:
id,name,age
 
The program should:
Read the file line by line
Clean and format the data
Ignore duplicate student entries
Handle invalid data without stopping the program
Store and display processed data
Write valid and invalid records to separate files
Log important steps during execution
 
Expected Behavior
Extra spaces in names should be removed
Student age must be 18 or above
Invalid records should be skipped and recorded
Duplicate students should be removed
Final valid students should be printed and saved
Use proper data types while reading numeric values
Compare objects correctly when removing duplicates
Ensure the program continues even if one record is invalid
Use efficient string manipulation for formatting
Do not use System.out.println for regular messages
 
Must Use
✔ String and common string methods
✔ StringBuilder
✔ Wrapper classes
✔ Autoboxing / Unboxing
✔ Arrays (for input parsing)
✔ Collections framework
✔ List, Set, Map
✔ ArrayList, HashSet, HashMap
✔ Iteration techniques (for-each / iterator)
✔ Proper object comparison
✔ Exception handling using try-catch-finally
✔ throw and throws
✔ At least one custom exception
✔ File input/output
✔ Reading and writing files
✔ Logging (no System.out.println)
 
Input Example (students.txt)
1, Ram ,22
2, Ravi,17
3, Raju ,22
x, John,25
 
Output Files
valid.txt → valid student records
invalid.txt → invalid or failed records */
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.stream.*;
class InvalidStudentDataException extends Exception {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}
public class javaproblem5 {
    public static void main(String args[]){
        Logger logger=Logger.getLogger("StudentDataLogger");
        HashSet<String> studentset=new HashSet<>();
        ArrayList<String> validstudents=new ArrayList<>();
        ArrayList<String> invalidstudents=new ArrayList<>();
        try(Scanner reader= new Scanner(new File("student.txt"))){
            while(reader.hasNextLine()){
                String line=reader.nextLine();
                String[] parts=line.split(",");
                try{
                    if(parts.length==3){
                        String id=parts[0].trim();
                        String name=parts[1].trim().replaceAll("\\s+"," ");
                        int age=Integer.parseInt(parts[2].trim());
                        if(age<18) {
                            throw new InvalidStudentDataException("Age must be 18 or above.");
                        }
                        String validRecord = id + "," + name + "," + age;
                        if(!studentset.contains(validRecord)){
                            studentset.add(validRecord);
                            validstudents.add(validRecord);
                            logger.log(Level.INFO,"Valid student added: {0}",validRecord);
                        }else{
                            logger.log(Level.WARNING,"Duplicate student record: {0}",validRecord);
                        }
                    }else{
                        invalidstudents.add(line);
                        logger.log(Level.WARNING,"Invalid format in line: {0}",line);
                    }
                }catch(InvalidStudentDataException e){
                    invalidstudents.add(line);
                    logger.log(Level.WARNING,"Invalid student data: {0}",e.getMessage());
                }catch(NumberFormatException e){
                    invalidstudents.add(line);
                    logger.log(Level.WARNING,"Number format error in line: {0}",line);
                }
           }
        }catch(Exception e){
            logger.log(Level.SEVERE,"Error reading input file: {0}",e.getMessage());
        }
    try{
        FileWriter validWriter=new FileWriter("valid.txt");
        for(String student:validstudents){
            validWriter.write(student+"\n");
        }
        validWriter.close();
        FileWriter invalidWriter=new FileWriter("invalid.txt");
        for(String student:invalidstudents){
            invalidWriter.write(student+"\n");
        }
        invalidWriter.close();
    }
    catch(IOException e){
        logger.log(Level.SEVERE,"Error writing to output files: {0}",e.getMessage());
    }finally{
        logger.info("Student data processing completed.");
    }

}
}