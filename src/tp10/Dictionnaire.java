package tp10;

import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			int number = (int)Math.random()* 0 + lblContent.size();
			word = lblContent.get(number);
			return word;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
