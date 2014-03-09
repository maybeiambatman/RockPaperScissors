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
        // TODO code application logic here
        boolean exit = false;
        
        while (!exit){
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter your move:\n"
                    + "> Rock\n"
                    + "> Paper\n"
                    + "> Scissors\n");

            String tempIn = reader.nextLine();
            
            int status = gameStatus();
            
            
            if (tempIn.equals("q"))
                System.exit(0);
            
            System.out.println("--------------");
            System.out.println("Your Move: "+tempIn);
            System.out.println("Computer's Move: "+computerMove(tempIn, status));
            if (status == 1)
                System.out.println("Congratulations! You Won!");
            else if (status == 2)
                System.out.println("You Tied :|");
            else
                System.out.println("Oh No! You Lost :(");
            System.out.println("--------------");
        }
    }
    
    public static int gameStatus(){
        
        // Our probability distribution
        // 40% change of winning
        // 30% chance of tying/drawing
        // 30% chacne of losing 
        int [] array = {1,1,1,1,0,0,0,2,2,2};
        
        // Used Java random function instead of Math.random() because
        // it is more efficient and less biased.
        Random rand = new Random();
        int  n = rand.nextInt(10);
        
        return array[n];
    }
    
    public static String computerMove(String userMove, int status){
        if (status == 2){
            return userMove;
        }
        
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
        
        return "";
    }
}
