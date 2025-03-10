package esercizi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SortWordsFromFileTest {

	String pathFileName = "src/text_files/word-list.txt";

	
	 @Test
	 void setFileNameTest() {
		 SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		 swff.setFileName(pathFileName);
		 assertEquals("word-list.txt", swff.getFileName());
	 }
	 
	 @Test
	 void sortEnumTest() {
	
	 }
	 
	 @Test
	 void sortTest() {
	
	 }
	 
	 @Test
	 void isWordPresentTest() {
		 SortWordsFromFile swff = new SortWordsFromFile(pathFileName);
		 assertTrue(swff.isWordPresent(" sono"));
		 assertTrue(swff.isWordPresent("sono"));
		 assertTrue(swff.isWordPresent("Sono"));
		 assertTrue(swff.isWordPresent("SONO"));
		 assertFalse(swff.isWordPresent("test"));
	 }
	 
	 @Test
	 void toStringTest() {
	
	 }
	 
	 @Test
	 void sortWordsFromFileTest() {
		 
	 }
	 
	 @Test
	 void sortWordsFromFileTestWithEnum() {
		 
	 }

}
