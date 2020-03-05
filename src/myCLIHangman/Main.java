package myCLIHangman;

public class Main {

	public static void main(String[] args) {
		
		//landing page
		System.out.println("Welcome to Hangman 1.0 (CLI)!");
		
		CLIHangman hangman = new CLIHangman();
		
		//System.out.println(hangman.getHangmanText());
		
		//Setup the game difficulty
		hangman.startupHangman();
		//System.out.println("TEST: Starting game at " + hangman.selectedDifficulty + " difficulty.");
		
		//Check if a playable option was selected
		if (hangman.active) {
			hangman.playHangman();
		}
		
		
		//System.out.println("TEST: Generate a random: " + hangman.randomIndex(hangman.HangmanText.length()));
		//System.out.println(hangman.hideText(hangman.HangmanText, "Hard"));
		

	}

}
