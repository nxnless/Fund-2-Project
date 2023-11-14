package Test;

import java.util.Random;

public class Test {
  public static void main(String[] args) {
    Random random = new Random();
   
    while(true) {
    int randomNumber = random.nextInt(6) + 1;
    System.out.println("Random number between 1 and 6: " + randomNumber);
}
  }
}
