package germanconsole;

public class Word {
	private String russianWord;
	private String germanWord;
	private String preteritum;
	private String partizip2;
	
	public Word(String russianWord, String germanWord, String preteritum, String partizip2) {
		this.russianWord = russianWord;
		this.germanWord = germanWord;
		this.preteritum = preteritum;
		this.partizip2 = partizip2;
	}
	
	public String getRussianWord() {
		return russianWord;
	}

	public String getGermanWord() {
		return germanWord;
	}
	
	public String getPreteritum() {
		return preteritum;
	}
	
	public String getPartizip2() {
		return partizip2;
	}
}
