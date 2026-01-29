import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.*;
public class javaproblem2 {
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String[] empnames={"John Doe","Jane Smith", "Alice Johnson", "Bob Brown", "Charlie Davis","John Doe"};
       ArrayList<String> empnameslist=new ArrayList<>(Arrays.asList(empnames)); //problem 2 1)
       System.out.println(Arrays.asList(empnames));
       HashSet<String> empnameset=new HashSet<String>(empnameslist);
       System.out.println(empnameset); //problem 2 2)
       HashMap<String,Integer> empnamemap=new HashMap<>();
       for(String name:empnameslist){
        empnamemap.put(name,empnamemap.getOrDefault(name, 0)+1);
       }
       System.out.println(empnamemap); //problem 2 3)
       //problem 2 4)
       Iterator<String>it=empnameset.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("The employee names are printed using Iterator.");
       }
   } 

