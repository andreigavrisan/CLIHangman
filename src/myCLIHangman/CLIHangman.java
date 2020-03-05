package myCLIHangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CLIHangman {
	
	
	public String HangmanText = "Hangman";
	public String[] difficulty = {"Easy", "Medium", "Hard", "None"};
	public String selectedDifficulty = "Easy";
	public boolean active = true;
	
	public CLIHangman()
	{
		//System.out.println("TEST: In CLIHangman constructor...");
		this.setHangmanText();
	};
	
	public String getHangmanText()
	{
		//System.out.println("TEST: In getHangmanText method...");
		return this.HangmanText;
	}
	
	private void setHangmanText()
	{
		//System.out.println("TEST: In setHangmanText method...");
		this.HangmanText = generateText();
	}
	
	private String generateText() {
		
		//System.out.println("TEST: In generateText method...");
		HangmanCountries hcountry = new HangmanCountries();		
		return hcountry.getCountry();
	}
	
	public void printMenu () {
		System.out.println("Select difficulty");
		System.out.println("1. Easy");
		System.out.println("2. Medium");
		System.out.println("3. Hard");
		System.out.println("0. Exit");
		System.out.print("Your option: ");
	}
	
	public void startupHangman ()
	{
		boolean MainLoop = true;
		String choice = "1";
		
		
		while (MainLoop){
			//System.out.println("In the MainLoop...");
			printMenu();
			
			try {
				InputStreamReader reader = new InputStreamReader (System.in);
				BufferedReader buffer = new BufferedReader(reader);
				choice = buffer.readLine();
			} 
			catch (Exception e)
			{ 
				System.err.println("Read failed:");
				e.printStackTrace();
			}
			
			switch(choice) {
			case "1":
				System.out.println("Easy difficulty selected");
				this.selectedDifficulty = this.difficulty[0];
				MainLoop = false;
				break;
			case "2": 
				System.out.println("Medium difficulty selected");
				this.selectedDifficulty = this.difficulty[1];
				MainLoop = false;
				break;
			case "3": 
				System.out.println("Hard difficulty selected");
				this.selectedDifficulty = this.difficulty[2];
				MainLoop = false;
				break;
			case "0": 
				{
					System.out.println("Exit selected. Good bye!");
					this.selectedDifficulty = this.difficulty[3];
					this.active = false;
					MainLoop = false;
					break;
				}
			default:
				System.out.println ("Please select a valid option.\n");
			}
					
		}
	}
	
	public void playHangman(){
		String hiddenText = this.hideText(this.HangmanText,this.selectedDifficulty);
		String correctText = this.HangmanText.toUpperCase();
		String upperChoice = "";
		System.out.println("\nFind the missing characters in: " + hiddenText);
		
		boolean gameOn = true;
		int answer = 0;
		int tries = 3;
		int sameChar = 0;
		
		char choice = 'a';
		char[] correctChars = correctText.toCharArray();
		char[] hiddenChars = hiddenText.toCharArray();
		
		while (gameOn)
		{
			System.out.print("Input a char: ");
			try {
				InputStreamReader reader = new InputStreamReader (System.in);
				BufferedReader buffer = new BufferedReader(reader);
				choice = buffer.readLine().charAt(0);
				upperChoice = String.valueOf(choice).toUpperCase();
				choice = upperChoice.charAt(0);
				//System.out.println("Read from the keyboard: buffer " +  buffer + "; with first char: " + upperChoice + " and char: " + choice);
				
			} 
			catch (Exception e)
			{ 
				//System.err.println("Read failed:");
				//e.printStackTrace();
			}
			
			//Validate char
			for (int i=0; i < correctChars.length; i++) {
				if (correctChars[i] == choice) 
				{
					if (choice == hiddenChars[i])
					{
						sameChar++;
					}
					else {
						hiddenChars[i] = choice;
						answer++;
					}
					
				}
				else {
					//System.out.println("Char not found at " + i + " th position.");
				}
			}
			
			hiddenText = String.valueOf(hiddenChars);
			
			if (hiddenText.equals(correctText)) {
				System.out.println("Congratulations! \nYou've won! \nThe correct answer was " + correctText);
				gameOn = false;
			}
			else {
					if (answer > 0) {
						System.out.println("Congratulations! You've guessed one letter! \n Current hangman: " + hiddenText);
					} 
					else {
						if (sameChar > 0){						
								tries--;
							
								System.out.println("Sorry! The letter was already visible! \nCurrent hangman: " + hiddenText);
							
							
								if (tries <= 0) {
									System.out.println ("Game Over! You've ran our of tries! \n The correct answer was: " + correctText);
									gameOn = false;
								}
								else {
									System.out.println("You have " + tries + " tries left.");
								}
						}
						else {
							tries--;
							
							System.out.println("Sorry! The letter is not correct! \n Current hangman: " + hiddenText);
														
							if (tries <= 0) {
								System.out.println ("Game Over! You've ran our of tries! \n The correct answer was: " + correctText);
								gameOn = false;
							}
							else {
								System.out.println("You have " + tries + " tries left.");
							}
						}
						
					}
				}
			
			answer = 0;
		}
	}
	
	public String hideText(String text, String difficulty)
	{
		String hiddenText = "";
		int countTextChars = text.length();
		char[] chars = text.toUpperCase().toCharArray();
		
		int hiddenIndex = randomIndex(text.length());
		//System.out.println("TEST: hiddenIndex is: " + hiddenIndex);
		
		char firstChar = chars[0];
		char lastChar = chars[countTextChars-1];
		char toHideChar = chars[hiddenIndex];
		//System.out.println("TEST: The FIRST char is: " + firstChar);
		//System.out.println("TEST: The LAST char is: " + lastChar);
		//System.out.println("TEST: To HIDE char is: " + toHideChar);
		
		switch (difficulty) {
		case "Easy":
			//One char hidden
			//System.out.println("TEST: HiddenTextEasy");	
			for (int i=1; i < countTextChars - 1; i++) {
				if (chars[i] == toHideChar) 
				{
					chars[i] = '*';
				}
			}
		hiddenText = String.valueOf(chars);
		//System.out.println("TEST: The EASY hiddenText is: " + hiddenText);
		break;
						
		case "Medium":
			//Only first and last chars visible
			//System.out.println("TEST: HiddenTextMedium");
			for (int i=1; i < countTextChars - 1; i++) {
				
				if ((chars[i] != firstChar) && (chars[i] != lastChar))
				{
					chars[i] = '*';
				}
			}
			hiddenText = String.valueOf(chars);
			//System.out.println("TEST: The MEDIUM hiddenText is: " + hiddenText);
			break;
		case "Hard":
			//No chars visible
			//System.out.println("TEST: HiddenTextHard");
			for (int i=0; i < countTextChars; i++) {
				chars[i] = '*';
			}
			hiddenText = String.valueOf(chars);
			//System.out.println("TEST: The HARD hiddenText is: " + hiddenText);
			break;
		}
		return hiddenText;
	}
	
	public int randomIntegerNumber (int min, int max)
	{
		int randomInteger = (int)(Math.random()*((max-min)+1))+min;
		//System.out.println("TEST: randomInteger generated: " + randomInteger);
		
		return randomInteger;
	}
	
	public int randomIndex (int length)
	{
		int minimum = 2;
		int maximum = length - minimum;
		int randomIndex = randomIntegerNumber(minimum, maximum);
		
		//System.out.println("TEST: randomIndex: " + randomIndex + "generated from minimum of " + minimum + " and maximum of " + maximum);
		return randomIndex;
	}
}
