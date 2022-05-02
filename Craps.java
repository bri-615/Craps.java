import java.util.concurrent.ThreadLocalRandom;
public class Craps {

   public static void main(String[] args) {
      ThreadLocalRandom rand = ThreadLocalRandom.current();

      // first roll
      int die1 = rand.nextInt(1, 7);
      int die2 = rand.nextInt(1, 7);
      final int firstSum = die1 + die2;
      System.out.printf("%d + %d = %d %n", die1, die2, firstSum);

      // Check if player wins or loses on first roll.
      if (firstSum == 7 || firstSum == 11) {
         System.out.println("You rolled " + die1 + " +" + die2 + " =" firstSum);
         System.out.println("You win because you got a natural :)");
         return;
      }
      if (firstSum == 2 || firstSum == 3 || firstSum == 12) {
         System.out.println("You rolled " + die1 + " +" + die2 + " =" firstSum);
         System.out.println("You lost because you got a crap out :(");
         return;
      }

      // The player did not win or lose on the first roll, so keep 
      // rolling until the new sum matches the first one or is equal 
      // to 7.
      System.out.println("Point is: " + firstSum);
      int newSum = 0;
      while (newSum != firstSum && newSum != 7) {
         die1 = rand.nextInt(1, 7);
         die2 = rand.nextInt(1, 7);
         newSum = die1 + die2;
         System.out.printf("%d + %d = %d %n", die1, die2, newSum);
      }

      if (newSum == firstSum) {
         System.out.println("You win because your roll matches point ;)");
      } else {
         System.out.println("You lost because your roll matches 7 :(");
      }
   }
}
