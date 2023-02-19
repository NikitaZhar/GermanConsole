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
				
		wordsList.add(new Noun("крыша", "das", "Dach", "Dächer", 0));
		wordsList.add(new Noun("тарелка", "der", "Teller", "Teller", 0));
		wordsList.add(new Noun("ложка", "der", "Löffel", "Löffel", 0));
		wordsList.add(new Noun("вилка", "die", "Gabel", "Gabeln", 0));
		wordsList.add(new Noun("нож", "das", "Messer", "Messer", 0));
		wordsList.add(new Noun("столовый прибор", "das", "Besteck", "Bestecke", 0));
		wordsList.add(new Noun("кастрюля", "der", "Kochtopf", "Kochtöpfe", 0));
		wordsList.add(new Noun("бутылка", "die", "Flasche", "Flaschen", 0));
		wordsList.add(new Noun("сковорода", "die", "Pfanne", "Pfannen", 0));
		wordsList.add(new Noun("плита", "der", "Herd", "Herde", 0));
		wordsList.add(new Noun("кухня", "die", "Küche", "Küchen", 0));
		wordsList.add(new Noun("яйцо", "das", "Ei", "Eier", 0));
		wordsList.add(new Noun("холодильник", "der", "Kühlschrank", "Kühlschränke", 0));
		wordsList.add(new Noun("хлеб", "das", "Brot", "Brote", 0));
		wordsList.add(new Noun("штаны", "die", "Hose", "Hosen", 0));
		wordsList.add(new Noun("рубашка", "das", "Hemd", "Hemden", 0));
		wordsList.add(new Noun("носок", "die", "Socke", "Socken", 0));
		wordsList.add(new Noun("жакет", "die", "Jacke", "Jacken", 0));
		wordsList.add(new Noun("свитер", "der", "Pullover", "Pullover", 0));
		wordsList.add(new Noun("обувь", "der", "Schuh", "Schuhe", 0));
		wordsList.add(new Noun("шляпа", "der", "Hut", "Hüte", 0));
		wordsList.add(new Noun("футболка", "das", "T-Shirt", "T-Shirts", 0));
		wordsList.add(new Noun("платье", "das", "Kleid", "Kleider", 0));
		wordsList.add(new Noun("блузка", "die", "Bluse", "Blusen", 0));
		wordsList.add(new Noun("юбка", "der", "Rock", "Röcke", 0));
		wordsList.add(new Noun("плавки", "die", "Badehose", "Badehosen", 0));
		wordsList.add(new Noun("купальник", "der", "Badeanzug", "Badeanzüge", 0));
		wordsList.add(new Noun("нижнее бельё ", "die", "Unterwäsche", "Unterwäschen", 0));
		wordsList.add(new Noun("майка", "das", "Unterhemd", "Unterhemden", 0));
		wordsList.add(new Noun("зонт", "der", "Regenschirm", "Regenschirme", 0));
		wordsList.add(new Noun("лужа", "die", "Pfütze", "Pfützen", 0));
		wordsList.add(new Noun("облако", "die", "Wolke", "Wolken", 0));
		wordsList.add(new Noun("штора", "der", "Vorhang", "Vorhänge", 0));
		wordsList.add(new Noun("помидор", "die", "Tomate", "Tomaten", 0));
		wordsList.add(new Noun("лимон", "die", "Zitrone", "Zitronen", 0));
		wordsList.add(new Noun("мука", "das", "Mehl", "...", 0));
		wordsList.add(new Noun("сахар", "der", "Zucker", "...", 0));
		wordsList.add(new Noun("молоко", "die", "Milch", "...", 0));
		wordsList.add(new Noun("масло", "die", "Butter", "...", 0));
		wordsList.add(new Noun("банан", "die", "Banane", "Bananen", 0));
		wordsList.add(new Noun("сыр", "der", "Käse", "...", 0));
		wordsList.add(new Noun("душ", "die", "Dusche", "Duschen", 0));
		wordsList.add(new Noun("диван", "das", "Sofa", "Sofas", 0));
		wordsList.add(new Noun("полотенце", "das", "Handtuch", "Handtücher", 0));
		wordsList.add(new Noun("лук", "die", "Zwiebel", "Zwiebeln", 0));
		wordsList.add(new Noun("пирог", "der", "Kuchen", "Kuchen", 0));
		wordsList.add(new Noun("водопроводный кран ", "der", "Wasserhahn", "Wasserhähne", 0));
		wordsList.add(new Noun("часы", "die", "Uhr", "Uhren", 0));
		wordsList.add(new Noun("корзина", "der", "Korb", "Körbe", 0));


		return wordsList.toArray(new Noun[0]);
	}
}
