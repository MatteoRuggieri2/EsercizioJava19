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
	 void getFileNameTest() {
	
	 }
	 
	 @Test
	 void sortEnumTest() {
	
	 }
	 
	 @Test
	 void sortTest() {
	
	 }
	 
	 @Test
	 void isWordPresentTest() {
	
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
