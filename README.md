# Collection

## SortWordsFromFile

L'obiettivo di questo esercizio è l'utilizzo di **Collections**, **Comparator**, e **StringBuilder**.

Creare la classe `SortWordsFromFile` che implementa l'interfaccia `ReadFromFile`, con relativo JUnit di test `SortWordsFromFileTest`.

All'interno della classe `SortWordsFromFile` inserire i seguenti costruttori:

```java
class SortWordsFromFile implements ReadFromFile {
    SortWordsFromFile(String fileName)
    SortWordsFromFile(String fileName, EnumSortType sortType)
}
```

> Il metodo **toString()** della classe restituisce una _stringa_ con tutte le parole incontrate.
Le parole devono essere trasformate in _UpperCase_, ordinate in modo _ascendente_ (alfabetico inverso) e _senza duplicati_.

### Output

Dopo aver letto un file di testo contenente parole separate da 1 o più spazi (parola1 parola2  parol...), restituire una stringa in **_UpperCase_** di parole **_non duplicate_** e seguendo l'**_ordinamento scelto_** attraverso l'enumerazione.

### Consigli

Specifica il metodo `toString()` all'interno della classe `SortWordsFromFile` e modificalo in maniera tale da restituire tutte le parole incontrate (trasformate in **UpperCase**).

## Files

**EnumSortType.java**

```java
enum EnumSortType {
    SORT_ASCENDING,
    SORT_DESCENDING,
}
```

**ReadFromFile.java**

```java
interface ReadFromFile {
    void setFileName(String fileName);
    void sort(EnumSortType sortType);
    void sort(); /* Sorting according default sort type */
    boolean isWordPresent(String word);
    String toString();
}
```

**word-list.txt**

```text
Queste sono   sono delle parole 
```
