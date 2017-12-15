package tp10;

import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Dictionnaire {
	public String filename;

	public Dictionnaire(String cfilename) {
		this.filename = cfilename;
	}

	public boolean find(String word) {
		Path p = Paths.get(filename);
		try {
			List<String> lblContent = new ArrayList<String>();
			lblContent = Files.readAllLines(p);
			for (String s : lblContent) {
				if (s.trim().contains(word)) {
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String choose() {
		String word = new String();
		Path p = Paths.get(filename);
		try {
			List<String> lblContent = new ArrayList<String>();
			lblContent = Files.readAllLines(p);
			int number = (int) Math.random() * 0 + lblContent.size();
			word = lblContent.get(number);
			return word;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String evaluer(String word, String tentative) {
		String reponse = null;
		List<String> listword = Arrays.asList(word);
		List<String> listtentative = Arrays.asList(tentative);
		int taille = listword.size();
		System.out.println("Le mot a "+ taille +" lettres et commence par "+ listword.get(0));
		if (listword.size() == listtentative.size()) {
			for (int i = 0; i < listword.size(); i++) {
				if (listtentative.get(i) == listword.get(i)) {
					reponse += "o";
				} else if (listword.contains(listtentative.get(i))) {
					reponse += "-";
				} else {
					reponse += "x";
				}
				listword.remove(i);
			}
			return (reponse);
		}
		return (null);
	}
}