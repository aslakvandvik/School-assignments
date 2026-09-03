package rockPaperScissors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest {
    
	private static ByteArrayOutputStream outputStream;
	
	@BeforeEach
	void setup() {
		outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
	}
	
	/**
	 * Test output of RPS game using rock. Single game.
	 */
	@Test
	void simpleRockRPSGame() {
    	String input = "rock\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertWinnerText(output[2]);
        assertScoreText(output[3]);
        assertContinuePlayText(output[4]);
        assertEndGameText(output[5]);
        assertThrows(NoSuchElementException.class, () -> RockPaperScissors.main(null));
    }
	
	/**
	 * Test output of RPS game using paper. Single game.
	 */
	@Test
	void simplePaperRPSGame() {
    	String input = "paper\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertWinnerText(output[2]);
        assertScoreText(output[3]);
        assertContinuePlayText(output[4]);
        assertEndGameText(output[5]);
    }
	
	/**
	 * Test output of RPS game using scissors. Single game.
	 */
	@Test
	void simpleScissorsRPSGame() {
    	String input = "scissors\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertWinnerText(output[2]);
        assertScoreText(output[3]);
        assertContinuePlayText(output[4]);
        assertEndGameText(output[5]);
    }
	
    @Test
    void incorrectRPSInput() {
    	String input = "papp\nrock\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertIncorrectInputText(output[2]);
        assertChoiceText(output[3]);
        assertWinnerText(output[4]);
        assertScoreText(output[5]);
        assertContinuePlayText(output[6]);
        assertEndGameText(output[7]);
    }
    
    @Test
    void incorrectContinuePlayInput() {
    	String input = "rock\nbruh\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertWinnerText(output[2]);
        assertScoreText(output[3]);
        assertContinuePlayText(output[4]);
        assertIncorrectInputText(output[5]);
        assertContinuePlayText(output[6]);
        assertEndGameText(output[7]);
    }
    
    @Test
	void playTwice() {
    	String input = "rock\ny\nrock\nn";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        RockPaperScissors.main(null);
        String[] output = outputStream.toString().split("\n");
        
        assertRoundText(output[0]);
        assertChoiceText(output[1]);
        assertWinnerText(output[2]);
        assertScoreText(output[3]);
        assertContinuePlayText(output[4]);
        assertRoundText(output[5]);
        assertChoiceText(output[6]);
        assertWinnerText(output[7]);
        assertScoreText(output[8]);
        assertContinuePlayText(output[9]);
        assertEndGameText(output[10]);
    }
    
    public void assertRoundText(String text) {
    	String[] correct = {"Let's", "play", "round"};
    	String[] words = text.strip().split(" ");
    	assertEquals(correct[0], words[0]);
    	assertEquals(correct[1], words[1]);
    	assertEquals(correct[2], words[2]);
    }
    
    public void assertChoiceText(String text) {
    	String correct = "Your choice (Rock/Paper/Scissors)?";
    	assertEquals(correct, text.strip().strip());
    }
    
    public void assertWinnerText(String text) {
    	String[] correct = {"Human", "chose", "computer", "chose"};
    	String[] words = text.strip().split(" ");
    	assertEquals(correct[0], words[0]);
    	assertEquals(correct[1], words[1]);
    	assertEquals(correct[2], words[3]);
    	assertEquals(correct[3], words[4]);
    }
    
    public void assertScoreText(String text) {
    	String[] correct = {"Score:", "human", "computer"};
    	String[] words = text.strip().split(" ");
    	assertEquals(correct[0], words[0]);
    	assertEquals(correct[1], words[1]);
    	assertEquals(correct[2], words[3]);
    }
    
    public void assertContinuePlayText(String text) {
    	String correct = "Do you wish to continue playing? (y/n)?";
    	assertEquals(correct, text.strip());
    }
    
    public void assertEndGameText(String text) {
    	String correct = "Bye bye :)";
    	assertEquals(correct, text.strip());
    }
    
    public void assertIncorrectInputText(String text) {
    	String[] correct = {"I", "do", "not", "understand", "Could", "you", "try", "again?"};
    	String[] words = text.strip().split(" ");
    	assertEquals(correct[0], words[0]);
    	assertEquals(correct[1], words[1]);
    	assertEquals(correct[2], words[2]);
    	assertEquals(correct[3], words[3]);
    	assertEquals(correct[4], words[5]);
    	assertEquals(correct[5], words[6]);
    	assertEquals(correct[6], words[7]);
    	assertEquals(correct[7], words[8]);
    }


}