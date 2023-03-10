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

			System.out.printf("%n%15s : %10s %s - die %s (%d) : ", 
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
				
		wordsList.add(new Noun("??????????", "das", "Dach", "D??cher", 0));
		wordsList.add(new Noun("??????????????", "der", "Teller", "Teller", 0));
		wordsList.add(new Noun("??????????", "der", "L??ffel", "L??ffel", 0));
		wordsList.add(new Noun("??????????", "die", "Gabel", "Gabeln", 0));
		wordsList.add(new Noun("??????", "das", "Messer", "Messer", 0));
		wordsList.add(new Noun("???????????????? ????????????", "das", "Besteck", "Bestecke", 0));
		wordsList.add(new Noun("????????????????", "der", "Kochtopf", "Kocht??pfe", 0));
		wordsList.add(new Noun("??????????????", "die", "Flasche", "Flaschen", 0));
		wordsList.add(new Noun("??????????????????", "die", "Pfanne", "Pfannen", 0));
		wordsList.add(new Noun("??????????", "der", "Herd", "Herde", 0));
		wordsList.add(new Noun("??????????", "die", "K??che", "K??chen", 0));
		wordsList.add(new Noun("????????", "das", "Ei", "Eier", 0));
		wordsList.add(new Noun("??????????????????????", "der", "K??hlschrank", "K??hlschr??nke", 0));
		wordsList.add(new Noun("????????", "das", "Brot", "Brote", 0));
		wordsList.add(new Noun("??????????", "die", "Hose", "Hosen", 0));
		wordsList.add(new Noun("??????????????", "das", "Hemd", "Hemden", 0));
		wordsList.add(new Noun("??????????", "die", "Socke", "Socken", 0));
		wordsList.add(new Noun("??????????", "die", "Jacke", "Jacken", 0));
		wordsList.add(new Noun("????????????", "der", "Pullover", "Pullover", 0));
		wordsList.add(new Noun("??????????", "der", "Schuh", "Schuhe", 0));
		wordsList.add(new Noun("??????????", "der", "Hut", "H??te", 0));
		wordsList.add(new Noun("????????????????", "das", "T-Shirt", "T-Shirts", 0));
		wordsList.add(new Noun("????????????", "das", "Kleid", "Kleider", 0));
		wordsList.add(new Noun("????????????", "die", "Bluse", "Blusen", 0));
		wordsList.add(new Noun("????????", "der", "Rock", "R??cke", 0));
		wordsList.add(new Noun("????????????", "die", "Badehose", "Badehosen", 0));
		wordsList.add(new Noun("??????????????????", "der", "Badeanzug", "Badeanz??ge", 0));
		wordsList.add(new Noun("???????????? ?????????? ", "die", "Unterw??sche", "Unterw??schen", 0));
		wordsList.add(new Noun("??????????", "das", "Unterhemd", "Unterhemden", 0));
		wordsList.add(new Noun("????????", "der", "Regenschirm", "Regenschirme", 0));
		wordsList.add(new Noun("????????", "die", "Pf??tze", "Pf??tzen", 0));
		wordsList.add(new Noun("????????????", "die", "Wolke", "Wolken", 0));
		wordsList.add(new Noun("??????????", "der", "Vorhang", "Vorh??nge", 0));
		wordsList.add(new Noun("??????????????", "die", "Tomate", "Tomaten", 0));
		wordsList.add(new Noun("??????????", "die", "Zitrone", "Zitronen", 0));
		wordsList.add(new Noun("????????", "das", "Mehl", "...", 0));
		wordsList.add(new Noun("??????????", "der", "Zucker", "...", 0));
		wordsList.add(new Noun("????????????", "die", "Milch", "...", 0));
		wordsList.add(new Noun("??????????", "die", "Butter", "...", 0));
		wordsList.add(new Noun("??????????", "die", "Banane", "Bananen", 0));
		wordsList.add(new Noun("??????", "der", "K??se", "...", 0));
		wordsList.add(new Noun("??????", "die", "Dusche", "Duschen", 0));
		wordsList.add(new Noun("??????????", "das", "Sofa", "Sofas", 0));
		wordsList.add(new Noun("??????????????????", "das", "Handtuch", "Handt??cher", 0));
		wordsList.add(new Noun("??????", "die", "Zwiebel", "Zwiebeln", 0));
		wordsList.add(new Noun("??????????", "der", "Kuchen", "Kuchen", 0));
		wordsList.add(new Noun("?????????????????????????? ???????? ", "der", "Wasserhahn", "Wasserh??hne", 0));
		wordsList.add(new Noun("????????", "die", "Uhr", "Uhren", 0));
		wordsList.add(new Noun("??????????????", "der", "Korb", "K??rbe", 0));


		return wordsList.toArray(new Noun[0]);
	}
}
