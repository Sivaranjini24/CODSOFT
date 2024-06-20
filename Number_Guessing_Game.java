import java.util.Random;        
import java.util.Scanner;       
public class Number_Guessing_Game
{
    public static void main(String args[])
    {
        int randomNo = 1 + (int)(100 * Math.random());
        int trycount = 0;
        while(trycount <= 10)
        {
            System.out.println("Enter your guess between(1-100)");
            Scanner s= new Scanner(System.in);
            int playerGuess = s.nextInt();
            if (randomNo == playerGuess)
            {
                System.out.println("Yes! You are right.");
                break;
            }
            else if(randomNo > playerGuess)
            {
                System.out.println("Your guess is low.. try again");
            }
            else if(randomNo < playerGuess)
            {
                System.out.println("Your guess  is high.. try again");
            }
        
        trycount++;
        System.out.println(10-trycount+" more chances to try.");
        }
        
        System.out.println("Attempts over!... \nBetter luck next time...");
    }
}



