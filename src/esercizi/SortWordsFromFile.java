package esercizi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import enums.EnumSortType;
import interfaces.ReadFromFile;

public class SortWordsFromFile implements ReadFromFile {
	
	// TODO - Questo è l'es 19
	
	private String fileName;
	
	private String fileContent; // Contiene il contenuto del file in una stringa
	
	private String[] fileWords;
	
	private String[] sortedFileWords; // Contiene le parole univoche e ordinate in base alla richiesta

		
	
	SortWordsFromFile(String filePath) {
		extractsStrings(filePath, null);
	}
	
	SortWordsFromFile(String filePath, EnumSortType sortType) {
		extractsStrings(filePath, sortType);
	}
	
	
	
	/* Questo metodo è quello principale, ha come compito quello
	 * di richiamare tutti gli altri metodi della classe che lavorano
	 * per rendere le parole del file, univoche, uppercase e ordinate. */
	private void extractsStrings(String filePath, EnumSortType sortType) {
		
		// Prendo il contenuto del file
		this.fileContent = readFile(filePath);
		
		// Prendo le parole del file. le separo e le rendo univoche
		this.fileWords = this.fileContent.split(" +");
		
		// Le ordino e le rendo univoche (grazie al TreeSet)
		if (sortType != null) {
			sort(sortType);
		} else {
			sort();
		}
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
	

	// Questo metodo ricava il nome del file e lo salva in this.fileName
	@Override
	public void setFileName(String filePath) {
		String[] pathSections = filePath.split("/");
		this.fileName = pathSections[pathSections.length - 1];
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String[] getSortedFileWords() {
		return this.sortedFileWords;
	}


	/* Questo metodo ordina le parole in base alla richiesta e
	le rende univoche (proprietà del TreeSet) */
	@Override
	public void sort(EnumSortType sortType) {
		
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
		
		for (String word : this.fileWords) {
			result.add(word);
		}
		
		this.sortedFileWords = result.toArray(new String[0]);
	}


	@Override
	public void sort() {
		sort(EnumSortType.SORT_ASCENDING);
	}


	@Override
	public boolean isWordPresent(String word) {
		for (String fileWord : this.sortedFileWords) {
			if (fileWord.equalsIgnoreCase(word.trim())) {
				return true;
			}
		}
		return false;
	}

	
	@Override
	public String toString() {
		return makeString(this.sortedFileWords);
	}
}



