import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class javaproblem1 {
    public static void main(String[] args) {
        try{
            File file=new File("input.txt");
            if(file.createNewFile()){
                System.out.println("File created: "+file.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try{
            FileWriter writer=new FileWriter("input.txt");
           writer.write("Java is a powerful programming language.   Java is used in web development, mobile apps, and backend systems. \r\n" + //
                              "Many developers love Java because Java is reliable and secure.  \r\n" + //
                              "\r\n" + //
                              "Learning Java takes practice, practice, and more practice.  \r\n" + //
                              "String handling in Java is very important for real applications.  \r\n" + //
                              "Java helps developers build fast and scalable software.\r\n" + //
                              "");
              writer.close();
        System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int charcount = 0;
        int wordcount=0;
        int sentencecount=0;
        String replacedata="";
        String reversesentence="";
        Map<String,Integer> freqwordcount=new HashMap<>();
        try(Scanner reader=new Scanner(new File("input.txt"))){
           while(reader.hasNextLine()){
            String data=reader.nextLine();
            charcount += data.replaceAll("\\s+", "").length();// counts characters excluding spaces
            wordcount+= data.split("\\s+").length;// \\s is a regex for whitespace
            sentencecount+= data.split("[.!?]+").length; // [.!?]+ is a regex which splits the line after every .,? or !
            replacedata += data.replaceAll("\\s+", " "); // replaces multiple spaces with single space
         // Reverse word order without reversing individual words
            String[] words_to_reverse = data.split("\\s+");
            List<String> wordList = new ArrayList<>(Arrays.asList(words_to_reverse));
            Collections.reverse(wordList);
            reversesentence += String.join(" ", wordList) + " ";
            System.out.println(data);           
            // Count word frequencies
            String data1=data.toLowerCase();
            String[] words=data1.split("\\W+");
            for(String word:words){
                if(!word.isEmpty()){
                    freqwordcount.put(word,freqwordcount.getOrDefault(word,0)+1);
                }
            }
           }
        }catch(Exception e){
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        // Display top 5 frequent words
        List<Map.Entry<String,Integer>> list=new ArrayList<>(freqwordcount.entrySet());
        //lambda expression to sort the list based on values
        list.sort((a,b) -> b.getValue().compareTo(a.getValue())); // Sort in descending order of frequency
        System.out.println("Top 5 frequent words:");
        for(int i=0;i<Math.min(5,list.size());i++){
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
        System.out.println("The total number of characters in the file is: " + charcount);
        System.out.println("The total number of words in the file is: " + wordcount);
        System.out.println("The total number of sentences in the file is: " + sentencecount);
        System.out.println("The above paragraph after replacing multiple spaces with single space is:\n " + replacedata);
        System.out.println("The above paragraph after reversing each sentence is:\n " + reversesentence);
    // String comparison
    String a="java";
    String b="java";
    String c=new String("java");
    try{
    System.out.println(a==b);
    System.out.println(a.equals(b));
    System.out.println(a==c);
    System.out.println(a.equals(c));

    }
    catch(Exception e){
        System.out.println("An error occurred while comparing strings.");
        e.printStackTrace();
    }
    }
}
