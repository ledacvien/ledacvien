/* Dac Vien Le
   CSC205
   Instructor: Prof. Simms
   Exam 1, Question 4
*/

import java.util.*;

class Wallaby{
   char gender;
   double weight;
   int age;
}

public class C205Exam1{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);

      double totalWeight = 0;
      char again;

      Wallaby female = new Wallaby();
      female.gender = 'F';

      Wallaby male1 = new Wallaby();
      male1.gender = 'M';
      male1.age = 2;
      male1.weight = 10.2;

      Wallaby male2 = new Wallaby();
      male2.gender = 'M';
      male2.age = 6;
      male2.weight = 18.5;

      do{ 
         System.out.println("Plese enter the age of the female wallaby: ");
         do{
            System.out.print("Age must be from 2 -> 15 : ");
            female.age = kb.nextInt();
         } while (female.age < 2 || female.age > 15);

         System.out.print("Plese enter the weight of the female wallaby: ");
         female.weight = kb.nextDouble();

         for (int year = 0; year < 10 ; year++) {
            totalWeight += TestWallaby (female, male1, 'M').weight;
            totalWeight += TestWallaby (female, male2, 'F').weight;
            female.age++;
            male1.age++;
            male2.age++;
         }

         System.out.println("Total weight of 20 wallaby babies after 10 years: " + totalWeight);

         System.out.print("Again (y/n): ");
         again = kb.next().charAt(0);
      } while (again == 'Y' || again == 'y');
   }

   public static Wallaby TestWallaby (Wallaby mom, Wallaby dad, char gender){
      Wallaby joey = new Wallaby();
      joey.age = 0;
      joey.gender = gender;

      if (mom.age < 4)
         joey.weight = dad.weight * 0.1;
      else if (mom.age < 12)
         joey.weight = dad.weight * 0.05;
      else 
         joey.weight = dad.weight * 0.03;

      return joey;
   }
}
