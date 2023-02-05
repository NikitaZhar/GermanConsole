package germanconsole;

public class Word {
	private String russianWord;
	private String germanWord;
	
	public Word(String russianWord, String germanWord) {
		this.russianWord = russianWord;
		this.germanWord = germanWord;
	}
	
	public String getRussianWord() {
		return russianWord;
	}

	public String getGermanWord() {
		return germanWord;
	}
}

class Verb extends Word {
	private String form1;
	private String form2;
	
	public Verb() {
		this("тест", "test", "test", "test");
	}
	
	public Verb(String russianWord, String germanWord, String form1, String form2) {
		super(russianWord, germanWord);
		this.form1 = form1;
		this.form2 = form2;
	}
	
	public void runTest() {
		System.out.println("Running test of Verbs");
	}
}

class Noun extends Word {
	private String article;
	private String plural;
	
	public Noun() {
		this("тест", "test", "test", "test");
	}

	public Noun(String russianWord, String article, String germanWord, String plural) {
		super(russianWord, germanWord);
		this.article = article;
		this.plural = plural;
	}
	
	public void runTest() {
		System.out.println("Running test of Nouns");
	}
}
