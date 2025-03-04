package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import enums.EnumSortType;

public class SortWordsFromFile {
	
	private String textFileFolderPath = "src/text_files/";
	
	private String fileContent;
	
	private String sortedWordsStr = "";
	
	

//	private Set<String> paroleUnicheInOrdineAlfabetico;
//	
//	private String[] revertedWords;
	
	
	public static void main(String[] args) {
		SortWordsFromFile sortWordsFromFile = new SortWordsFromFile("word-list.txt");
		
	}

	
	
	SortWordsFromFile(String fileName) {
		//TODO
		/* - Leggo il file
		 * - Leggo tutte le parole
		 * - Trasformo tutte le parole in UPPERCASE
		 * - Rendo le parole UNIVOCHE
		 * - Le ordino in ordine alfabetico
		 * - Stampo la stringa contenente le parole ordinate
		 * */
		
		// Prendo il contenuto del file
		this.fileContent = readFile(textFileFolderPath + fileName);
		
		// Metto le parole in un array (posso fare un metodo che le mette già univoche)
		String[] fileWords = this.fileContent.split(" +");
		
		// Le rendo univoche
		ArrayList<String> uniqueFileWords = new ArrayList<String>();
		for (String word : fileWords) {
			if (!uniqueFileWords.contains(word.toUpperCase())) {
				uniqueFileWords.add(word.toUpperCase());
			}
		}
		
		// Le ordino in modo alfabetico
		uniqueFileWords.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		
		for (String string : uniqueFileWords) {
			sortedWordsStr += string + ", ";
		}
		
		System.out.println(sortedWordsStr);
	}
	
	SortWordsFromFile(String fileName, EnumSortType sortType) {
		//TODO
		// Stessa cosa del costruttore sopra ma qui imposto il tipo di ordinamento
	}
	
	
//	
//	private void run() {
//		
//		/* Esiste un costruttore di TreeSet che accetta come paramtro un Comparator (che è un interfaccia)
//		 * dove io vado ad implementare un metodo compare, in modo che quando il mio treeSet dovrà mettere
//		 * in ordine gli elementi, richiamerà il metodo che io ho scritto (che ha sovrascritto il suo).
//		 * In questo caso c'è prima s2 e poi s1 in modo che li mette in ordine contrario.
//		 * 
//		 * Nello specifico ecco come il comparator gestisce il suo ordinamento:
//		 * ritorna un int -1 se deve spostare l'elemento indietro, 0 se deve rimanere al suo posto, 
//		 * 1 se deve spostarlo avanti. */
//		paroleUnicheInOrdineAlfabetico = new TreeSet<String>(
//			// Classe anonima
//			new Comparator<String>() {
//				public int compare(String s1, String s2) {
//					return s2.compareTo(s1);   // s1, s2 ordine alfabetico | s2, s1 ordine alf invertito
//				}
//			}
//		);
//		
//	
//		// Funzione che apre il file e restituisce il contenuto
//		this.fileContent = readFile(this.pathFileName);
//		
//		// Splitto la stringa, elimino i doppioni e metto le parole in ordine ALFABETICO INVERTITO (ho sovrascritto l'ordinamento di default del TreeSet)
//		splittaStringaEMettileInOrdineAlfabetico(fileContent);
//		System.out.println("Parole in ordine: " + this.paroleUnicheInOrdineAlfabetico);
//
//	}
//	
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
//	
//	/* Questa funzione prende una stringa, la splitta e poi mette le parole dentro
//	 * un treeSet, quindi toglie i duplicati e le mette in ordine alfabetico */
//	private void splittaStringaEMettileInOrdineAlfabetico(String text) {
//		
//		
//		// Splitto il testo
//		this.splittedText = this.splitString(text, " +");
//		
//		// Inserisco le parole nel treeset (in automatico le ordina in ordine alfabetico)
//		for (String word : this.splittedText) {
//			this.paroleUnicheInOrdineAlfabetico.add(word.toLowerCase());
//		}
//
//	}

}

























