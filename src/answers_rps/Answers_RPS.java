/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package answers_rps;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author mohdirteza
 */
public class Answers_RPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Flag to show if the program is going to run 
        boolean exit = false;
        
        while (!exit){
            
            // Initializes scanner
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter your move:\n"
                    + "> (r) Rock\n"
                    + "> (p) Paper\n"
                    + "> (s) Scissors\n"
                    + "> (q) Quit Game\n"
                    + "------------------");
            
            // Read the next input line
            String tempIn = reader.nextLine();
            
            // Checks if user quit the game
            if (tempIn.toLowerCase().equals("q")){
                exit = true;
                System.exit(0);
            }
            
            // Basic input validation
            if (tempIn.toLowerCase().equals("rock") || tempIn.equals("r")
                    || tempIn.toLowerCase().equals("paper") || tempIn.equals("p")
                    || tempIn.toLowerCase().equals("scissors") || tempIn.equals("s")){
                
                // Some basic input checking
                if (tempIn.toLowerCase().equals("rock") || tempIn.equals("r"))
                    tempIn = "Rock";

                if (tempIn.toLowerCase().equals("paper") || tempIn.equals("p"))
                    tempIn = "Paper";

                if (tempIn.toLowerCase().equals("scissors") || tempIn.equals("s"))
                    tempIn = "Scissors";

                // Determines if the user won
                int status = gameStatus();

                // Print results
                System.out.println("------------------");
                System.out.println("Your Move: "+tempIn);
                System.out.println("Computer's Move: "+computerMove(tempIn, status));
                if (status == 1)
                    System.out.println("Congratulations! You Won!");
                else if (status == 2)
                    System.out.println("You Tied :|");
                else
                    System.out.println("Oh No! You Lost :(");
                System.out.println("------------------");
            }
            else{
                // Print user input is invalid
                System.out.println(tempIn+" is not a valid input");
            }
        }
    }
    
    // Helper function to check who won the game
    public static int gameStatus(){
        
        // Our weighted probability distribution
        // 40% change of winning
        // 30% chance of tying/drawing
        // 30% chacne of losing 
        int [] array = {0,0,0,1,1,1,1,2,2,2};
        
        // Used Java random function instead of Math.random() because
        // it is more efficient and less biased.
        Random rand = new Random();
        int  n = rand.nextInt(10);
        
        // Returns a game result at random
        return array[n];
    }
    
    // Determines the computer generated output
    public static String computerMove(String userMove, int status){        
        
        // If user loses return appropriate output
        if (status == 0){
            if (userMove.equals("Paper")){
                return "Scissors";
            }
            if (userMove.equals("Rock")){
                return "Paper";
            }
            if (userMove.equals("Scissors")){
                return "Rock";
            }
        }
        
        // If user wins return appropriate output
        if (status == 1){
            if (userMove.equals("Paper")){
                return "Rock";
            }
            if (userMove.equals("Rock")){
                return "Scissors";
            }
            if (userMove.equals("Scissors")){
                return "Paper";
            }
        }
        
        // If draw return the same input as user
        if (status == 2){
            return userMove;
        }
        
        // Empty string
        return "";
    }
}
