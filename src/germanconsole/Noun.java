package germanconsole;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

//Class Noun

class Noun extends Word {
	private String article;
	private String plural;
	private int knowWordCount;

	
	public Noun(String russianWord, String article, String germanWord, String plural, int knowWordCount) {
		super(russianWord, germanWord);
		this.article = article;
		this.plural = plural;
	}
	
	public String getArticle() {
		return article;
	}

	public String getPlural() {
		return plural;
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

	public void runTest() {
		System.out.println("Running test of Nouns");
	}
}

//Class Nouns

class Nouns {
	private int numberOfWordsForTest = 5; 
	static Random rn = new Random();

	protected Noun[] selectNounsForTest() {
		Noun[] listOfNouns = initNouns();
		Noun[] nounsForTest = new Noun[numberOfWordsForTest];
		int[] listOfIndexes = shuffleArrayOfIndex(listOfNouns.length);

		for (int index = 0; index < numberOfWordsForTest; index++) {
			nounsForTest[index] = listOfNouns[listOfIndexes[index]];			
		}
		return nounsForTest;
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

	public void runTestOfNouns() {
		Noun[] nounsForTest = selectNounsForTest();
		boolean selector = true;
		int indexCount = 0;

		Scanner console = new Scanner(System.in);
		System.out.println("\nKnow (1) - Don't know (2) - Exit (0) ...");
		int[] indexArray = shuffleArrayOfIndex(nounsForTest.length);

		while (selector) {

			System.out.printf("%n%15s : %10s %s, die %s (%d) : ", 
					nounsForTest[indexArray[indexCount]].getRussianWord(), 
					nounsForTest[indexArray[indexCount]].getArticle(),
					nounsForTest[indexArray[indexCount]].getGermanWord(),
					nounsForTest[indexArray[indexCount]].getPlural(),
					nounsForTest[indexArray[indexCount]].getKnowWordCount());

			int nextNoun = console.nextInt();

			switch(nextNoun) {
			case 1 -> nounsForTest[indexArray[indexCount]].addKnowWordCount();
			case 2 -> nounsForTest[indexArray[indexCount]].subKnowWordCount();
			case 0 -> selector = false;
			}

			indexCount++;
			if (indexCount >= nounsForTest.length) {
				indexCount = 0;
				indexArray = shuffleArrayOfIndex(nounsForTest.length);
			}
		}
	}

	private Noun[] initNouns() {
		ArrayList <Noun> wordsList = new ArrayList();
				
		wordsList.add(new Noun("крыша", "das", "Dach", "Dächer", 0));
		wordsList.add(new Noun("тарелка", "der", "Teller", "Teller", 0));
		wordsList.add(new Noun("ложка", "der", "Löffel", "Löffel", 0));
		wordsList.add(new Noun("вилка", "die", "Gabel", "Gabeln", 0));
		wordsList.add(new Noun("нож", "das", "Messer", "Messer", 0));
		wordsList.add(new Noun("столовый прибор", "das", "Besteck", "Bestecke", 0));
		wordsList.add(new Noun("кастрюля", "der", "Kochtopf", "Kochtöpfe", 0));

		
		// die Flasche
		// die Pfanne
		// der Herd
		// die Küche
		// das Ei
		// die Zwiebel
		// der Jogurt
		// der Kühlschrank, ä -e
		// das Brot, -e

		
		
		

		return wordsList.toArray(new Noun[0]);
	}
}
