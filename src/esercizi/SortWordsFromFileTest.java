package esercizi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import enums.EnumSortType;

class SortWordsFromFileTest {

	String pathFileName = "src/text_files/word-list.txt";
	
	String[] wordsSortByASC = {"delle", "parole", "queste", "sono"};
	
	String[] wordsSortByDESC = {"sono", "queste", "parole", "delle"};
	
	@Test
	void setFileNameTest() {
		SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		swff.setFileName(pathFileName);
		assertEquals("word-list.txt", swff.getFileName());
	}
	
	// Constructor test
	@Test
	void sortTest() {
		SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		assertArrayEquals(wordsSortByASC, swff.getSortedFileWords());
	}
	
	// Constructor test
	@Test
	void sortEnumTest() {
		SortWordsFromFile swffASC = new SortWordsFromFile(pathFileName, EnumSortType.SORT_ASCENDING);
		SortWordsFromFile swffDESC = new SortWordsFromFile(pathFileName, EnumSortType.SORT_DESCENDING);
		assertArrayEquals(wordsSortByASC, swffASC.getSortedFileWords());
		assertArrayEquals(wordsSortByDESC, swffDESC.getSortedFileWords());
	}
	
	@Test
	void isWordPresentTest() {
		SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		assertTrue(swff.isWordPresent(" sono"));
		assertTrue(swff.isWordPresent("sono "));
		assertTrue(swff.isWordPresent(" sono "));
		assertTrue(swff.isWordPresent("sono"));
		assertTrue(swff.isWordPresent("Sono"));
		assertTrue(swff.isWordPresent("SONO"));
		assertFalse(swff.isWordPresent("test"));
	}
	
	@Test
	void toStringTest() {
		String expectedString = "DELLE, PAROLE, QUESTE, SONO.";
		SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		assertEquals(expectedString, swff.toString());
		System.out.println(swff.toString());
	}

}