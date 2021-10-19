/* Dac Vien Le
   CSC205
   Instructor: Prof. Simms
   Program #4
*/

/* Note: 
      
      Sack test not completed
      Go fish not completed
*/

import java.util.*;

class Sack{
   private static final int ALLOC = 50;
   private static Random _gen = new Random();
   private int _size;
   //String[] _store;
   private Object[] _store;

   public Sack(){
      _size = 0;
      //_store = new String[ALLOC];
      _store = new Object[ALLOC];
   }

   public int getSize(){
      return _size;
   }

   public String toString(){
      String ans = "";
      for(int i = 0; i < _size; ++i)
         ans += _store[i].toString() + "\n";        // check this line if any errors occur
      return ans;
   }

   private void expandStore (int pos){
      if( _size != 0 && _size == _store.length)
      {
         //String[] temp = new String[ _size + ALLOC];
         Object[] temp = new Object[ _size + ALLOC];
         for(int i = 0; i < _store.length; ++i)
            temp[i] = _store[i];
         _store = temp;
      }

      _size++;
      for(int i = _size; i > pos; i--)
         _store[i] = _store[i-1];
   }
   public void insert (Object newObj, int pos){
      // always make sure there will enough space.
      // pos-1 represents string at pos-nth in the store
      pos--;
      if(pos < 0 || pos > _size) return;
      expandStore(pos);
      _store[pos] = newObj;
   }

   // return the first position of inStr
   private int search (Object inObj){
      for(int i = 0; i < _size; ++i){
         if( _store[i].equals( inObj ))
            return i;
      }
      // if the for-loop cannot find the position of inStr, return -1
      return -1;
   }

   // after deletion, there is a gap at 'pos'
   // this code will fill that gap with the right side element.
   private void resizeStore (int pos){
      _size--;
      for(int i = pos; i < _size; ++i)
         _store[i] = _store[i + 1];
   }

   // delete a String from storage.
   public Object delete (Object inObj){
      int pos = search(inObj);
      if( _size == 0 || pos == -1) return null;

      Object ans = _store[pos];
      resizeStore(pos);

      return ans;
   }

   // delete a random string from storage.
   public Object deleteAny(){
      int pos = _gen.nextInt( _size);
      return delete( _store[pos]);
   }

   // count duplicate string.
   public int count (String inStr){
      int ans = 0;
      for (int i = 0; i < _size; ++i) {
         if( _store[i].equals( inStr ) )
            ans++;
      }
      return ans;
   }

}

class Card{
   private static final String[] SUIT = {"Clubs", "Diamonds", "Hearts", "Spades"};
   private static final String[] VALUE = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King"};

   private int _suit;
   private int _value;

   public Card (int s, int v){
      _suit = s;
      _value = v;
   }

   public int getSuit(){
      return _suit;
   }
   public int getValue(){
      return _value;
   }

   public boolean equals (Card other){
      return ( _value == other.getValue());
   }

   public String toString(){
      return VALUE[ _value - 1] " of " + SUIT[ _suit - 1];
   }
}

public class CSC205P4{
   Scanner kb = new Scanner(System.in);

   public static void main (String[] args){

      System.out.println("Welcome to Go Fish card game !!!");
      System.out.println(" You will play this game with computer. Good luck !!!");
      
      int userOption = -1;

      while (userOption != 3)
      {
         System.out.println("Main Menu: " +
                           "\n  (1) Test the Sack before playing." +
                           "\n  (2) Play Go Fish !!!" +
                           "\n  (3) Quit :( \n");

         System.out.print("Please enter your option: ");
         userOption = kb.nextInt();
         while(userOption < 1 || userOption > 3){
            System.out.print("Enter 1, 2, or 3: ");
            userOption = kb.nextInt();
         }

         switch (userOption) {
            // Test Sack
            case 1:
               int pickSack = -1;
               int pickOption = -1;
               char again;

               Sack s1 = new Sack();
               Sack s2 = new Sack();
               s1.insert("DVIENLE", 1);
               s1.insert("CSC205", 2);
               s1.insert("Guitar is better than piano", 3);

               do{
                  System.out.println("\n\nYou will be offered 2 sacks to manipulate with");

                  System.out.print(" Please choose sack (1) or (2): ");
                  pickSack = kb.nextInt();
                  while (pickSack != 1 || pickSack != 2){
                     System.out.print("Enter '1' or '2': ");
                     pickSack = kb.nextInt();
                  }

                  System.out.println("\n Sub Menu for Operation: " +
                                    "\n  (1) Insert a given string" +
                                    "\n  (2) Delete a given string" +
                                    "\n  (3) Delete a random string (computer choice)" +
                                    "\n  (4) Count the number of a given string in the sack" +
                                    "\n  (5) Count all strings in sack" +
                                    "\n  (6) Print out all strings in sack" +
                                    "\n  (7) Quick");       

                  System.out.print("\n Enter you option: ");
                  pickOption = kb.nextInt();
                  while (pickOption < 1 || pickOption > 7){
                     System.out.print(" Your option must be from 1-7: ");
                     pickOption = kb.nextInt();
                  }

                  switch (pickOption) {
                     case 1:
                        String inStr;
                        int pos; 

                        System.out.print("\n Enter your string: ");
                        inStr = kb.next();
                        System.out.println(" Enter the position for the string in sack");

                        if (pickSack == 1){
                           pos = inputPos(s1.getSize() + 1);
                           s1.insert(inStr, pos);
                        }
                        if (pickSack == 2){
                           pos = inputPos(s2.getSize() + 1);
                           s2.insert(inStr, pos);
                        }

                        System.out.println(" Task completed !!");
                        break;
                     case 2:

                        break;
                     case 3:

                        break;
                     case 4: 

                        break;
                     case 5:

                        break;
                     case 6:

                        break;
                     case 7:
                        // exit
                  }

                  System.out.print("Again (y/n): ");
                  again = kb.next().charAt(0);

               } while (again == 'y' || again == 'Y');
               
               break;

            // play Go Fish
            case 2:

               break;
            case 3:
               // Exit
         }
      }

   }

   public static int inputPos(int limit){
      int pos;
      do{
         System.out.prinf(" Position must be in range [1, %d]: ", limit);
         pos = kb.nextInt();
      } while (pos < 1 || pos > limit);
      return pos;
   }
}