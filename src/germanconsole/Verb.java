package germanconsole;

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
		System.out.println("\nKnow (1) - Don't know (2) - Exit (0) ...");
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
		
		wordsList.add(new Verb("есть", "essen", "aß", "gegessen", 0));
		wordsList.add(new Verb("пить", "trinken", "trank", "getrunken", 0));
		wordsList.add(new Verb("идти", "gehen", "ging", "gegangen", 0));
		wordsList.add(new Verb("бежать", "laufen", "lief", "gelaufen", 0));
		wordsList.add(new Verb("ехать", "fahren", "fuhr", "gefahren", 0));
		wordsList.add(new Verb("давать", "geben", "gab", "gegeben", 0));
		wordsList.add(new Verb("приходить", "kommen", "kam", "gekommen", 0));
		wordsList.add(new Verb("просить", "bitten", "bat", "gebeten", 0));
		wordsList.add(new Verb("оставаться", "bleiben", "blieb", "geblieben", 0));
		wordsList.add(new Verb("падать", "fallen", "fiel", "gefallen", 0));
		wordsList.add(new Verb("помогать", "helfen", "half", "geholfen", 0));
		wordsList.add(new Verb("читать", "lesen", "las", "gelesen", 0));
		wordsList.add(new Verb("лететь", "fliegen", "flog", "geflogen", 0));
		wordsList.add(new Verb("брать", "nehmen", "nahm", "genommen", 0));
		wordsList.add(new Verb("писать", "schreiben", "schrieb", "geschrieben", 0));
		wordsList.add(new Verb("находить", "finden", "fand", "gefunden", 0));
		wordsList.add(new Verb("петь", "singen", "sang", "gesungen", 0));
		wordsList.add(new Verb("закрывать", "schließen", "schloss", "geschlossen", 0));
		wordsList.add(new Verb("висеть", "hängen", "hing", "gehangen", 0));
		wordsList.add(new Verb("ловить", "fangen", "fing", "gefangen", 0));
		wordsList.add(new Verb("приносить", "bringen", "brachte", "gebracht", 0));
		wordsList.add(new Verb("стоять", "stehen", "stand", "gestanden", 0));
		wordsList.add(new Verb("спать", "schlafen", "schlief", "geschlafen", 0));
		wordsList.add(new Verb("видеть", "sehen", "sah", "gesehen", 0));
		wordsList.add(new Verb("быть", "sein", "war", "gewesen", 0));
		wordsList.add(new Verb("иметь", "haben", "hatte", "gehabt", 0));

		// erklären  | erklärte, erklärt |

		return wordsList.toArray(new Verb[0]);
	}
}