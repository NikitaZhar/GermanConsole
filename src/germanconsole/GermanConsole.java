package germanconsole;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GermanConsole {

	static Word[] listOfVerbs;
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		boolean continueLesson = true;
		int selector = 0;
		
		while (continueLesson) {
			System.out.println("       Menu       \n------------------");
			System.out.println("0. Exit");
			System.out.println("1. Irregular Verbs");
			System.out.println("2. Nouns");
			String selectorInput = console.nextLine();
						
			try {
				selector = Integer.parseInt(selectorInput);
			} catch (NumberFormatException nfe) {
				System.out.println("Press number ...\n");
				continue;
			}
			
			switch(selector) {
				case 0 -> continueLesson = false;
				case 1 -> irregularVerbsTest();
				case 2 -> nounsTest();
				default -> System.out.println("Choose from 0 to 2...\n\n\n\n\n\n\n\n\n");
			}			
		}
		
	}
	
	static void irregularVerbsTest() {
		Scanner console = new Scanner(System.in);
		
		initVerbs();

		System.out.println("Press 0 to exit");

		while (true) {
			Random rn = new Random();
			int index = rn.nextInt(listOfVerbs.length);
		
			System.out.printf("%n%15s : %10s - %s - %s %n", listOfVerbs[index].getRussianWord(), 
					listOfVerbs[index].getGermanWord(),
					listOfVerbs[index].getPreteritum(),
					listOfVerbs[index].getPartizip2());
			
			int nextVerb = console.nextInt();			
			if (nextVerb == 0) break;
		}
	}
	
	static void nounsTest() {
		
	}
	
	static void initVerbs() {
		
		ArrayList <Word> wordsList = new ArrayList();
		
		wordsList.add(new Word("есть", "essen", "aß", "gegessen"));
		wordsList.add(new Word("пить", "trinken", "trank", "getrunken"));
		wordsList.add(new Word("идти", "gehen", "ging", "gegangen"));
		wordsList.add(new Word("бежать", "laufen", "lief", "gelaufen"));
		wordsList.add(new Word("ехать", "fahren", "fuhr", "gefahren"));
		wordsList.add(new Word("давать", "geben", "gab", "gegeben"));
		wordsList.add(new Word("приходить", "kommen", "kam", "gekommen"));
		wordsList.add(new Word("просить", "bitten", "bat", "gebeten"));
		wordsList.add(new Word("оставаться", "bleiben", "blieb", "geblieben"));
		wordsList.add(new Word("падать", "fallen", "fiel", "gefallen"));
		wordsList.add(new Word("помогать", "helfen", "half", "geholfen"));
		wordsList.add(new Word("читать", "lesen", "las", "gelesen"));
		wordsList.add(new Word("лететь", "fliegen", "flog", "geflogen"));
		wordsList.add(new Word("брать", "nehmen", "nahm", "genommen"));
		wordsList.add(new Word("писать", "schreiben", "schrieb", "geschrieben"));
		wordsList.add(new Word("находить", "finden", "fand", "gefunden"));
		wordsList.add(new Word("петь", "singen", "sang", "gesungen"));
		wordsList.add(new Word("закрывать", "schließen", "schloss", "geschlossen"));
		wordsList.add(new Word("висеть", "hängen", "hing", "gehangen"));
		wordsList.add(new Word("ловить", "fangen", "fing", "gefangen"));

		
		listOfVerbs = wordsList.toArray(new Word[0]);
		
		
//		listOfVerbs[0] = new Word("есть", "essen", "aß", "gegessen");
	}
}
