import javax.swing.*;
import java.util.HashSet;
     public class arrays {
         public static void main(String[] args) {
             HashSet<String> number = new HashSet<String>();
             number.add("0");
             number.add("0");
             number.add("1");
             number.add("1");
             number.add("1");
             number.add("2");
             number.add("2");
             number.add("3");
             number.add("3");
             number.add("4");

             System.out.println(number);

             for (int i = 0; i < number.size(); i++) {

                 if (number == number)
                     System.out.println("_");
                 

             }
         }
     }



