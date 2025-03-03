package interfaces;

import enums.EnumSortType;

public interface ReadFromFile {
	void setFileName(String fileName);
    void sort(EnumSortType sortType);
    void sort(); /* Sorting according default sort type */
    boolean isWordPresent(String word);
    String toString();
}
