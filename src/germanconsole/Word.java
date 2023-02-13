package germanconsole;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

// Class Word

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




