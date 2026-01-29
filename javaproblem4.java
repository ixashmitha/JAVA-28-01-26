import java.util.*;
import java.io.*;
import java.util.logging.*;
public class javaproblem4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String numinput1="0123";
        String numinput2="4567.678";
        String numinput3="8901";
        sc.close();
        int number1=0;
        float number2=0; //problem 4.2
        int number3=0;
        try{
            number1=Integer.parseInt(numinput1);
            number2=Float.parseFloat(numinput2);
            number3=Integer.parseInt(numinput3);
        }catch(NumberFormatException e){
            System.out.println("Invalid number format: " + e.getMessage()); //problem 4.4
        }
        ArrayList<Float> numlist=new ArrayList<Float>();
        numlist.add((float)number1);
        numlist.add(number2);   
        numlist.add((float)number3);
        Collections.sort(numlist); 
        System.out.println(numlist);
       int intsum=0;
       float floatsum=0;
       int floatcount=0;
        for(Float num:numlist){
            if(num%1==0){
                intsum+=num.intValue();
            }else{
                floatsum+=num.floatValue();//problem 4.3
                floatcount++;
            }
        }
        double floatavg=(floatcount==0)?0:(floatsum/floatcount); //problem 4.4
        System.out.println("Sum of integers: "+intsum);
        System.out.println("Average of floats: "+floatavg);
    }
}


