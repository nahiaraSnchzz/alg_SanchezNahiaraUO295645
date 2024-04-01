package algestudiante.p5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PatternMatchingTest {
	String text;
	List<String> patterns; // patrones
	List<Boolean> expectedResults; // resultado esperado
	
	@Test
	public void test1() {
		loadData("src/main/java/algestudiante/p5/test1.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			patternMatching.checkPattern(patterns.get(i));
			assertEquals(expectedResults.get(i), patternMatching.checkPattern(patterns.get(i)));
			//patternMatching.printsTable();	
		}
	}
	
	@Test
	public void test2() {
		loadData("src/main/java/algestudiante/p5/test2.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			assertEquals(expectedResults.get(i), 
					patternMatching.checkPattern(patterns.get(i)));
			patternMatching.printsTable();	
		}
	}
	
	@Test
	public void test3() {
		loadData("src/main/java/algestudiante/p5/test3.txt");		
		PatternMatching patternMatching = new PatternMatching(text);		
		for (int i = 0; i < patterns.size(); i++) {			
			assertEquals(expectedResults.get(i), patternMatching.checkPattern(patterns.get(i)));
			patternMatching.printsTable();	
		}
	}
	

	private void loadData(String file) {
		BufferedReader reader = null;
		this.patterns = new ArrayList<String>();
		this.expectedResults = new ArrayList<Boolean>();	

		try {
			reader = new BufferedReader(new FileReader(file));
			this.text = reader.readLine(); 	
			while (reader.ready()) {
				String[] parts = reader.readLine().split(" ");
				this.patterns.add(parts[0]);
				this.expectedResults.add(Boolean.valueOf(parts[1]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
