package rockPaperScissors;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;


public class RockPaperScissors {
	
    public static void main(String[] args) {
    	/* 	
    	 * The code here does two things:
    	 * It first creates a new RockPaperScissors -object with the
    	 * code `new RockPaperScissors()`. Then it calls the `run()`
    	 * method on the newly created object.
         */
        new RockPaperScissors().run();
    } 

    Scanner sc = new Scanner(System.in);
    int roundCounter = 1;
    int humanScore = 0;
    int computerScore = 0;
    List<String> rpsChoices = Arrays.asList("rock", "paper", "scissors");
    
    public void run() {
        // Write your code here :)
    }

    /**
     * Reads input from console with given prompt
     * @param prompt
     * @return string input answer from user
     */
    public String readInput(String prompt) {
        System.out.println(prompt);
        String userInput = sc.next();
        return userInput;
    }

}