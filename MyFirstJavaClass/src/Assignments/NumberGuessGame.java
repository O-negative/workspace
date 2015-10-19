package Assignments;

/**  
* NumberGuessGame.java
* A simple class for demonstrating the basics of command-line java utilizing user input to play a number guessing game
* by first selecting the range of numbers being generated, verifying that the input of the user matches the selection criteria
* and then providing feedback to the user in terms of whether their guess is correct, is higher or lower until the number is
* finally guessed.
*
* @author  Danny Gibson - dg0123@uw.edu
* @version 1.0.00 
* @see Scanner
* @see ArrayList
*/

import java.util.Scanner;
import java.util.ArrayList;

public class NumberGuessGame 
{
  @SuppressWarnings("resource")
public static void main(String args[])
  {
	/**
	* Create new Scanner object (scan) by requesting user to choose range size
	* Declare variables to be used after selection process
	* User must enter specific string values otherwise prompted to try again!
	* Once range size is choosen, rangeNumber variable is used in calculation
	* User can specify upper or lower case letter, both allowed using Regular Expression in a hasNext method
	*
	* Set cont
	* @param cont A variable of type String.
	*
	* Set iterations
	* @param iterations A variable of type Integer.
	*
	* Set range
	* @param range A variable of type String.
	*
	* Set rangeNumber
	* @param rangeNumber A variable of type Integer.
	*/
		
		
	String cont = "Y";
	Integer iterations = 0;
	while (cont.equals("Y"))
	{
		Scanner play = new Scanner(System.in);
		if (iterations < 1)
		{
			System.out.println("Welcome User, would you like to play a Number Guessing Game?");
		}
		else
		{
			System.out.println("User, would you like to play again?");
		}
		while (!play.hasNext("[YyNn]"))
		{
			System.out.println("That's not Y or N, Try Again!");
			play.next();
		}
		cont = play.next();
		cont = cont.toUpperCase();
		if (cont.equals("N"))
			System.exit(0);
		
		
		Integer rangeNumber = 0;
		String range;
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose how wide a range of numbers would you like to guess from.");
		System.out.println("Enter A for a range of 1 to 10.\nEnter B for range of 1 to 50.\nEnter C for range of 1 to 100.");
		while (!scan.hasNext("[ABCabc]"))
		{
			System.out.println("That's not A, B or C, Try Again!");
			scan.next();
		}
			range = scan.next();
			range = range.toUpperCase();
			if (range.equals("A"))
			{
				rangeNumber = 10;
			}
			if (range.equals("B"))
			{
				rangeNumber = 50;
			}
			if (range.equals("C"))
			{
				rangeNumber = 100;
			}
		System.out.println("Thank you! You entered " + range);


		/**
		* Create new Scanner object (keyboard) by requesting user to choose a number between 1 and range selected previously
		* Declare variables to be for random number generation, tracking guess and number of tries required
		* User must enter specific integer values otherwise prompted to try again!
		* Once guess number entered, guess variable is used to determine whether number equals random number generated
		* If guess is correct game ends and number of tries are displayed
		* If guess does not equal generated number, value entered is compared and user is instructed to guess again either lower or higher
		*
		* Set numTries to 0
		* @param numTries A variable of type Integer.
		*
		* Set generateNum from 1 + (random method * max rangeNumber variable)
		* @param generateNum A variable of type Integer.
		*
		* Set guess to 0
		* @param guess A variable of type Integer.
		*
		* Declare Integer ArrayList
		* @param guessedNumbers An arraylist of type Integer
		*
		*/
		
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("I am thinking of a number from 1 to "
			+ 
			rangeNumber
			+ 
			" ... guess what it is ?");
		
		Integer numTries = 0;
		Integer generateNum = 1 + (int) (Math.random() * rangeNumber);
		Integer guess = 0;
		ArrayList<Integer> guessedNumbers = new ArrayList<Integer>();
	
		while (guess != generateNum)
		{
			while(!keyboard.hasNextInt())
			{
				System.out.println("Input doesn't match Integer specifications. Try again.");
				keyboard.next(); 
			}
			guess = keyboard.nextInt();
			guessedNumbers.add(guess);
			numTries++;
			if (guess > generateNum)
			{
				System.out.println("choose a lower number!");
			} else if (guess < generateNum)
			{
				System.out.println("choose a higher number!");
			}
		}
		
		
		
		/**
		* The System.out.println is being used to validate the program by displaying all values previously entered
		* or created based on those values.  This helps to understand that the logic within the program appears
		* to function correctly and as expected.
		*/
		
		System.out.println(
			"Congratulations .\nThe range you selected was \""
			+
			range
			+
			"\" which resulted in a randomly selected number between 1 and "
			+
			rangeNumber
			+
			".\nThe number randomly generated was "
			+
			generateNum
			+
			"\nYou finally guessed the number "
			+
			guess
			+
			"\nWhich took you "
			+ 
			numTries 
			+ 
			" tries!\nAll the numbers you guessed were: "
			+
			guessedNumbers
			+
			"\n\n");
			iterations++;
		
	}
  }
}