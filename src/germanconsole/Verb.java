package germanconsole;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

// Class Verb

class Verb extends Word {
	private String form1;
	private String form2;
	private int knowWordCount;

	public Verb(String russianWord, String germanWord, String form1, String form2, int knowWordCount) {
		super(russianWord, germanWord);
		this.form1 = form1;
		this.form2 = form2;
	}

	public String getForm1Word() {
		return form1;
	}

	public String getForm2Word() {
		return form2;
	}

	public int getKnowWordCount() {
		return knowWordCount;
	}


	protected void addKnowWordCount() {
		knowWordCount ++;
	}

	protected void subKnowWordCount() {
		knowWordCount --;
		if (knowWordCount < 0) knowWordCount = 0;
	}

}

// Class Verbs

class Verbs {
	private int numberOfWordsForTest = 5; 
	static Random rn = new Random();

	protected Verb[] selectVerbsForTest() {
		Verb[] listOfVerbs = initVerbs();
		
		
//		// Write the array of Verbs
//		
//		FileWriter locFile = null;
//		try {
//			locFile = new FileWriter("verbs.txt");
//			for (Verb verb : listOfVerbs) {
//				locFile.write(
//						verb.getRussianWord() + "," +
//						verb.getGermanWord() + "," +
//						verb.getForm1Word() + "," +
//						verb.getForm2Word() + "," +
//						verb.getKnowWordCount() + "\n"
//						);
//			}
//		} catch (IOException e) {
//			
//		} finally {
//			try {
//				locFile.close();
//			} catch (IOException e) {
//				
//			}
//		}
//		
//	// End writing	
		
		Verb[] verbsForTest = new Verb[numberOfWordsForTest];
		int[] listOfIndexes = shuffleArrayOfIndex(listOfVerbs.length);

		for (int index = 0; index < numberOfWordsForTest; index++) {
			verbsForTest[index] = listOfVerbs[listOfIndexes[index]];			
		}
		return verbsForTest;
	}

	protected int[] shuffleArrayOfIndex(int arraySize) {
		int[] listOfIndexes = IntStream.rangeClosed(0, arraySize - 1).toArray();

		for (int index = 0; index < arraySize; index++) {
			int randomIndex = index + rn.nextInt(arraySize - index);
			int temp = listOfIndexes[index];
			listOfIndexes[index] = listOfIndexes[randomIndex];
			listOfIndexes[randomIndex] = temp;
		}
		return listOfIndexes;
	}

	// Run Test	

	public void runTestOfVerbs() {
		Verb[] verbsForTest = selectVerbsForTest();
		boolean selector = true;
		int indexCount = 0;
		Scanner console = new Scanner(System.in);
		
		System.out.println("\nKnow (1) - Don't know (2) - Exit (0) : ");
		int[] indexArray = shuffleArrayOfIndex(verbsForTest.length);

		while (selector) {

			System.out.printf("%n%15s : %10s - %s - %s (%d) : ", 
					verbsForTest[indexArray[indexCount]].getRussianWord(), 
					verbsForTest[indexArray[indexCount]].getGermanWord(),
					verbsForTest[indexArray[indexCount]].getForm1Word(),
					verbsForTest[indexArray[indexCount]].getForm2Word(),
					verbsForTest[indexArray[indexCount]].getKnowWordCount());

			int nextVerb = console.nextInt();

			switch(nextVerb) {
			case 1 -> verbsForTest[indexArray[indexCount]].addKnowWordCount();
			case 2 -> verbsForTest[indexArray[indexCount]].subKnowWordCount();
			case 0 -> selector = false;
			}

			indexCount++;
			if (indexCount >= verbsForTest.length) {
				indexCount = 0;
				indexArray = shuffleArrayOfIndex(verbsForTest.length);
			}
		}
	}

	private Verb[] initVerbs() {
		ArrayList <Verb> wordsList = new ArrayList();
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("verbs.txt"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {
				String rus = scanner.next();
				scanner.skip(scanner.delimiter());
				String ger = scanner.next();
				scanner.skip(scanner.delimiter());
				String form1 = scanner.next();
				scanner.skip(scanner.delimiter());
				String form2 = scanner.next();
				scanner.skip(scanner.delimiter());
				int count = Integer.parseInt(scanner.nextLine());
				wordsList.add(new Verb(rus, ger, form1, form2, count));
			}
		} catch(IOException e) {
			
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		
		
		
		
		
//		wordsList.add(new Verb("????????", "essen", "a??", "gegessen", 0));
//		wordsList.add(new Verb("????????", "trinken", "trank", "getrunken", 0));
//		wordsList.add(new Verb("????????", "gehen", "ging", "gegangen", 0));
//		wordsList.add(new Verb("????????????", "laufen", "lief", "gelaufen", 0));
//		wordsList.add(new Verb("??????????", "fahren", "fuhr", "gefahren", 0));
//		wordsList.add(new Verb("????????????", "geben", "gab", "gegeben", 0));
//		wordsList.add(new Verb("??????????????????", "kommen", "kam", "gekommen", 0));
//		wordsList.add(new Verb("??????????????", "bitten", "bat", "gebeten", 0));
//		wordsList.add(new Verb("????????????????????", "bleiben", "blieb", "geblieben", 0));
//		wordsList.add(new Verb("????????????", "fallen", "fiel", "gefallen", 0));
//		wordsList.add(new Verb("????????????????", "helfen", "half", "geholfen", 0));
//		wordsList.add(new Verb("????????????", "lesen", "las", "gelesen", 0));
//		wordsList.add(new Verb("????????????", "fliegen", "flog", "geflogen", 0));
//		wordsList.add(new Verb("??????????", "nehmen", "nahm", "genommen", 0));
//		wordsList.add(new Verb("????????????", "schreiben", "schrieb", "geschrieben", 0));
//		wordsList.add(new Verb("????????????????", "finden", "fand", "gefunden", 0));
//		wordsList.add(new Verb("????????", "singen", "sang", "gesungen", 0));
//		wordsList.add(new Verb("??????????????????", "schlie??en", "schloss", "geschlossen", 0));
//		wordsList.add(new Verb("????????????", "h??ngen", "hing", "gehangen", 0));
//		wordsList.add(new Verb("????????????", "fangen", "fing", "gefangen", 0));
//		wordsList.add(new Verb("??????????????????", "bringen", "brachte", "gebracht", 0));
//		wordsList.add(new Verb("????????????", "stehen", "stand", "gestanden", 0));
//		wordsList.add(new Verb("??????????", "schlafen", "schlief", "geschlafen", 0));
//		wordsList.add(new Verb("????????????", "sehen", "sah", "gesehen", 0));
//		wordsList.add(new Verb("????????", "sein", "war", "gewesen", 0));
//		wordsList.add(new Verb("??????????????????", "erkl??ren", "erkl??rte", "erkl??rt", 0));
//		wordsList.add(new Verb("????????", "wohnen", "wohnte", "gewohnt", 0));
//		wordsList.add(new Verb("??????????????????????????", "sprechen", "sprach", "gesprochen", 0));
//		wordsList.add(new Verb("????????????????", "antworten", "antwortete", "geantwortet", 0));
//		wordsList.add(new Verb("??????????????", "h??ren", "h??rte", "geh??rt", 0));
//		wordsList.add(new Verb("??????????????????", "wiederholen", "wiederholte", "wiederholt", 0));
//		wordsList.add(new Verb("????????????????????", "fragen", "fragte", "gefragt", 0));
//		wordsList.add(new Verb("??????????????????, ???????? ?? ????????", "passen", "passte", "gepasst", 0));
//		wordsList.add(new Verb("????????????????????", "hei??en", "hie??", "gehei??en", 0));
//		wordsList.add(new Verb("????????????", "spielen", "spielte", "gespielt", 0));
//		wordsList.add(new Verb("??????????????????", "rechnen", "rechnete", "gerechnet", 0));
//		wordsList.add(new Verb("????????????????", "arbeiten", "arbeitete", "gearbeitet", 0));
//		wordsList.add(new Verb("??????????", "haben", "hatte", "gehabt", 0));


		return wordsList.toArray(new Verb[0]);
	}
}
