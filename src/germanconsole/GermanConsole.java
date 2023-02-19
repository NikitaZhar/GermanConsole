package germanconsole;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GermanConsole {
	
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Verbs verbs = new Verbs();
		Nouns nouns = new Nouns();
				
		boolean continueLesson = true;

		while (continueLesson) {
			switch(mainMenuInput()) {
			case 0 -> continueLesson = false;
			case 1 -> verbs.runTestOfVerbs();
			case 2 -> nouns.runTestOfNouns();
			default -> System.out.println("Choose from 0 to 9...\n\n\n\n\n\n\n");
			}			
		}
	}
	
	private static int mainMenuInput() {

		int selector = 0;

		while (true) {
			String textBlock = """
				   
				   
				   Available actions:

					0. Exit
					1. Verbs learning
					2. Nouns learning
					3. Add new Verb
					4. Add new Noun
					
					9. Options

					Enter a number : """;
			System.out.printf(textBlock + "  ");
			
			String selectorInput = console.nextLine();
			try {
				selector = Integer.parseInt(selectorInput);
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\n* * * Wrong selection! * * *\n\n\n");
				continue;
			}
		}
		return selector;
	}
}
