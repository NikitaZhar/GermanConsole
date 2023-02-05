package germanconsole;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GermanConsole {

	static WordOld[] listOfVerbs;
	
	public static void main(String[] args) {
		
		Verb verbs = new Verb();
		Noun nouns = new Noun();
		
		Scanner console = new Scanner(System.in);
		
		boolean continueLesson = true;
		int selector = 0;
		
		while (continueLesson) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n       Menu       \n------------------");
			System.out.println("0. Exit");
			System.out.println("1. Verbs");
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
				case 1 -> verbs.runTest();
				case 2 -> nouns.runTest();
				
//				case 1 -> irregularVerbsTest();
//				case 2 -> nounsTest();
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
		
		ArrayList <WordOld> wordsList = new ArrayList();
		
		wordsList.add(new WordOld("есть", "essen", "aß", "gegessen"));
		wordsList.add(new WordOld("пить", "trinken", "trank", "getrunken"));
		wordsList.add(new WordOld("идти", "gehen", "ging", "gegangen"));
		wordsList.add(new WordOld("бежать", "laufen", "lief", "gelaufen"));
		wordsList.add(new WordOld("ехать", "fahren", "fuhr", "gefahren"));
		wordsList.add(new WordOld("давать", "geben", "gab", "gegeben"));
		wordsList.add(new WordOld("приходить", "kommen", "kam", "gekommen"));
		wordsList.add(new WordOld("просить", "bitten", "bat", "gebeten"));
		wordsList.add(new WordOld("оставаться", "bleiben", "blieb", "geblieben"));
		wordsList.add(new WordOld("падать", "fallen", "fiel", "gefallen"));
		wordsList.add(new WordOld("помогать", "helfen", "half", "geholfen"));
		wordsList.add(new WordOld("читать", "lesen", "las", "gelesen"));
		wordsList.add(new WordOld("лететь", "fliegen", "flog", "geflogen"));
		wordsList.add(new WordOld("брать", "nehmen", "nahm", "genommen"));
		wordsList.add(new WordOld("писать", "schreiben", "schrieb", "geschrieben"));
		wordsList.add(new WordOld("находить", "finden", "fand", "gefunden"));
		wordsList.add(new WordOld("петь", "singen", "sang", "gesungen"));
		wordsList.add(new WordOld("закрывать", "schließen", "schloss", "geschlossen"));
		wordsList.add(new WordOld("висеть", "hängen", "hing", "gehangen"));
		wordsList.add(new WordOld("ловить", "fangen", "fing", "gefangen"));
		
		listOfVerbs = wordsList.toArray(new WordOld[0]);
		
//		listOfVerbs[0] = new Word("есть", "essen", "aß", "gegessen");
	}
}
