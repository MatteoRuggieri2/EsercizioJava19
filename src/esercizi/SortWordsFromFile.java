package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import enums.EnumSortType;
import interfaces.ReadFromFile;

public class SortWordsFromFile implements ReadFromFile { // TODO DEVE implementare l'interfaccia
	
	// TODO - Questo è l'es 19
	
	private String fileName;
	
	private String fileContent; // Contiene il contenuto del file in una stringa
	
	private String[] sortedWords; // Contiene le parole univoche e ordinate in base alla richiesta
	
	
	//TODO - Da rimuovere e testare in JUnit
	public static void main(String[] args) {
		SortWordsFromFile swff = new SortWordsFromFile("src/text_files/word-list.txt");
		SortWordsFromFile swff2 = new SortWordsFromFile("src/text_files/word-list.txt", EnumSortType.SORT_ASCENDING);
		SortWordsFromFile swff3 = new SortWordsFromFile("src/text_files/word-list.txt", EnumSortType.SORT_DESCENDING);
	}
	
	
	
	SortWordsFromFile(String filePath) {
		extractsStrings(filePath, null);
		System.out.println(this.toString()); //TODO - Da rimuovere
	}
	
	SortWordsFromFile(String filePath, EnumSortType sortType) {
		extractsStrings(filePath, sortType);
		System.out.println(this.toString()); //TODO - Da rimuovere
	}
	
	
	
	/* Questo metodo è quello principale, ha come compito quello
	 * di richiamare tutti gli altri metodi della classe che lavorano
	 * per rendere le parole del file, univoche, uppercase e ordinate. */
	void extractsStrings(String filePath, EnumSortType sortType) {
		
		// Prendo il contenuto del file
		this.fileContent = readFile(filePath);
		
		// Prendo le parole del file. le separo e le rendo univoche
		String[] fileWords = this.fileContent.split(" +");
		
		// Le ordino e le rendo univoche (grazie al TreeSet)
		this.sortedWords = sortWords(fileWords, sortType);
	}
	
	
	/* Questo metodo ordina le parole in base alla richiesta e
	le rende univoche (proprietà del TreeSet) */
	private String[] sortWords(String[] uniqueFileWords, EnumSortType sortType) {
		
		/* Esiste un costruttore di TreeSet che accetta come paramtro un Comparator
		 * (che è un interfaccia) dove io vado ad implementare un metodo compare,
		 * in modo che quando il mio treeSet dovrà mettere in ordine gli elementi,
		 * richiamerà il metodo che io ho scritto (che ha sovrascritto il suo).
		 * In questo caso c'è prima s2 e poi s1 in modo che li mette in ordine DESC. */
		Set<String> result = new TreeSet<String>(
			// Classe anonima
			new Comparator<String>() {
				public int compare(String s1, String s2) {
					// s1, s2 ordine alfabetico | s2, s1 ordine alf invertito
					if (sortType == EnumSortType.SORT_DESCENDING) {
						return s2.compareTo(s1);
					} else {
						return s1.compareTo(s2);
					}
				}
			}
		);
		
		for (String word : uniqueFileWords) {
			result.add(word);
		}
		
		return result.toArray(new String[0]);
	}


	// Questa funzione prende il path del file, apre il file e ritorna una stringa con il contenuto
	private String readFile(String path) {
		
		String fileContentString = "";
		
		// Apro il file
		File inputFile = new File(path);
		
		// Leggo il file con lo scanner
		try {
			Scanner scanner = new Scanner(inputFile);
			
			// Salvo la stringa nativa dal file
			fileContentString = scanner.nextLine();
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return fileContentString;
	}
	
	
	/* Questo metodo, dato un array di parole, forma la
	stringa con virgole e punto alla fine utilizzando
	la classe ottimizzata StringBuilder di Java. */
	private String makeString(String[] words) {
		StringBuilder sb = new StringBuilder();
		
		for (String word : words) {
			sb.append(word.toUpperCase() + ", ");
		}
		return sb.substring(0, sb.length() - 2) + ".";
	}
	
	
	@Override
	public String toString() {
		return makeString(this.sortedWords);
	}



	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public void sort(EnumSortType sortType) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isWordPresent(String word) {
		// TODO Auto-generated method stub
		return false;
	}

}



