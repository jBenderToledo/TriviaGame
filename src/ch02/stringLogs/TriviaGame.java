package ch02.stringLogs;
import java.util.*;

/*
 * Tools used: Eclipse, source code for LinkedStringLog and LLStringNode
 * 	provided by Object-Oriented Data Structures using Java, 3rd Edition
 * 	written by Nell Dale, Daniel T. Joyce, and Chip Weems.
 */

/**
 * @author Jonathan Bender
 */
public class TriviaGame
{

	public static void main(String[] args)
	{
		final int NUMBER_OF_QUESTIONS = 11;
		final int QUESTION_LIMIT = 6;
		final int PASSING_NUMBER = 4;
		
		LinkedStringLog[] triviaQuestion = new LinkedStringLog[NUMBER_OF_QUESTIONS];
		String[][] triviaAnswers = new String[NUMBER_OF_QUESTIONS][];
		Scanner in = new Scanner(System.in);
		
		boolean[] hasBeenAskedBefore = new boolean[NUMBER_OF_QUESTIONS];
		byte numberOfQuestionsAsked;
		byte numberOfCorrectAnswers;
		int questionIndex;
		
		triviaQuestion[0] = new LinkedStringLog(
			"What is the derivative of 1 relative to x?");
		triviaAnswers[0] = new String[] {
				"0", "zero"
		};
		
		triviaQuestion[1] = new LinkedStringLog(
			"What is a first name of one of the members of the Beatles?");
		triviaAnswers[1] = new String[] {
				"John", "Paul", "George", "Ringo"
		};
		
		triviaQuestion[2] = new LinkedStringLog(
			"What is the sixteenth letter of the alphabet?");
		triviaAnswers[2] = new String[] {
				"p"
		};
		
		triviaQuestion[3] = new LinkedStringLog(
			"What is the author's full name (First Last)?");
		triviaAnswers[3] = new String[] {
				"Jonathan Bender", "Bender, Jonathan"
		};
		
		triviaQuestion[4] = new LinkedStringLog(
			"What is the radix when counting in hexadecimal?");
		triviaAnswers[4] = new String[] {
				"16", "sixteen", "6+10", "10+6", "6 + 10", "10 + 6"
		};
		
		triviaQuestion[5] = new LinkedStringLog(
			"What is a way using only OR (|), AND (&), and NOT (!) to state A XOR B?");
		triviaAnswers[5] = new String[] {
				"(A OR B) AND NOT (A AND B)", "(A | B) & !(A & B)", "(A | B) & (A & B)'",
				"(A|B)&!(A&B)", "(A|B)&(A&B)'"
		};
		
		triviaQuestion[6] = new LinkedStringLog(
			"What is the runeword for Stealth in Diablo II?");
		triviaAnswers[6] = new String[] {
				"TalEth", "Tal Eth"
		};
		
		triviaQuestion[7] = new LinkedStringLog(
			"Name one of the authors of Object-Oriented Data Structures Using Java. "
			+	"(Last OR First Last OR Last, First");
		triviaAnswers[7] = new String[] {
				"Dale", "Joyce", "Weems", "Nell Dale", "Daniel Joyce", "Chip Weems",
				"Dale, Nell", "Joyce, Daniel", "Weems, Chip"
		};
		
		triviaQuestion[8] = new LinkedStringLog(
			"In x86 assembly, name the opcode used to exchange two locations A and B.");
		triviaAnswers[8] = new String[] {
				"XCHG\tA,B", "XCHG A,B", "XCHG\tA, B", "XCHG A, B"
		};
	
		triviaQuestion[9] = new LinkedStringLog(
			"What is 1 + 1?");
		triviaAnswers[9] = new String[] {
				"2", "two", "TRUE", "11", "0b10", "10b"
		};
		
		triviaQuestion[10] = new LinkedStringLog(
			"A troll stands before you. What do you do?");
		triviaAnswers[10] = new String[] {
				"Get eaten by a grue", "Go north", "Get ye flask", "Counterspell",
				"Pay 1 life, exile a blue card from my hand hand, then cast Force of Will"
				
		};
		
		for (int index = 0; index < triviaQuestion.length; index++)
		{
			triviaQuestion[index].insertAll(triviaAnswers[index]);
		}
		
		while(true)
		{
			numberOfQuestionsAsked = 0;
			numberOfCorrectAnswers = 0;
			hasBeenAskedBefore = new boolean[NUMBER_OF_QUESTIONS];
			
			System.out.println("Answer 4 of 6 randomly-chosen questions to win!");
			System.out.println();
			
			while (numberOfQuestionsAsked < QUESTION_LIMIT)
			{
				numberOfQuestionsAsked++;
				
				do
				{
					questionIndex = (new Random()).nextInt(NUMBER_OF_QUESTIONS);
				} while (hasBeenAskedBefore[questionIndex]);
				hasBeenAskedBefore[questionIndex] = true;
				
				System.out.println("Question "
						+ numberOfQuestionsAsked
						+ ": "
						+ triviaQuestion[questionIndex].getName()
				);
				
				System.out.print("> ");
				
				if ( triviaQuestion[questionIndex].contains(in.nextLine()) )
				{
					numberOfCorrectAnswers++;
					System.out.println("Correct!");
					System.out.println();
				}
				else
				{
					System.out.println("False. Here are some acceptable answers. "
							+ "If you answered correctly, consult the author.");
					System.out.println();
					System.out.println(triviaQuestion[questionIndex].toString());
				}
			}
			
			System.out.printf("Questions asked: %d\n", numberOfQuestionsAsked);
			System.out.printf("Correct answers: %d\n\n", numberOfCorrectAnswers);
			
			
			if (numberOfCorrectAnswers >= PASSING_NUMBER)
			{
				System.out.print("Congratulations! You win! Your prize: NOTHING!\n\n");
				in.close();
				return;
			}
			else
			{
				System.out.println("You lose.\n\n");
			}
		}
		
	}

}
