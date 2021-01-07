import java.util.*;

/** Klasse Borg aus Aufgabe 10
*/
public class IntArrayList implements List<Integer> {

	public static void main(String[] args) {
		IntArrayList intArray = new IntArrayList();
		System.out.println("Erste Ausgabe der Liste : " + intArray.toString()); 
		System.out.println("Size : " + intArray.size());
		System.out.println("Leer ? : " + intArray.isEmpty());
		
		intArray.add(3);
		intArray.add(5);
		intArray.add(1, 15);
		System.out.println("Zweite Ausgabe der Liste : " + intArray.toString()); 
		
		intArray.remove(15);
		System.out.println("Dritte Ausgabe der Liste : " + intArray.toString()); 
		
		intArray.clear();
		System.out.println("Letzte Ausgabe der Liste : " + intArray.toString()); 
	}

	private int[] intArrayList;

/** Konstruktor der Klasse IntArrayList. Initialisiert das Array
*/
	public IntArrayList() {
		intArrayList = new int[0];
	}

/** Methode zur Ausgabe des Arrays
  * @return die Werte des Arrays als String
*/
	public String toString() {		
		String stringArrayList = "";
		int size = size();
		
		for (int i = 0; i < size; i++) {
			stringArrayList += intArrayList[i];
			
			if (i < size - 1) {
				stringArrayList += ", ";
			} else {
				stringArrayList += ".";
			}
		}
		return stringArrayList;
	}

/** Methode zur Ausgabe der Länge des Arrays
  * @return die Länge des Arrays
*/	
	public int size() {
		return intArrayList.length;
	}

/** Methode zum Überprüfen, ob es Werte in das Array gibt
  * @return true, wenn leer und false wenn nicht
*/	
	public boolean isEmpty() {
		if (intArrayList == null) {
			return true;
		}
		
		int totalValue = 0;
		for (int intValue : intArrayList) {
			totalValue += intValue;
		}
		if (totalValue == 0) {
			return true;
		} else {
			return false;
		}
	}

/** Methode zum Überprüfen, ob es einen Wert in das Array gibt
  * @param o ist der Wert, den gerüft werden soll
  * @return true, wenn es diesen Wert gibt und false wenn nicht
*/	
	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}
		Integer value = 0;
		if (o.getClass() != value.getClass()) {
			return false;
		}
		value = (Integer) o;
		for (int intValue : intArrayList) {
			if (value.equals(intValue)) {
				return true;
			}
		}
		return false;
	}

/** Methode zum Hinzufügen eines Wertes in das Array
  * @param value ist der Wert, der hinzugefügt werden soll
  * @return true
*/	
	public boolean add(Integer value) {
		int size = size();
		int[] copyIntArrayList = new int[size];
		for (int i = 0; i < size; i++) {
			copyIntArrayList[i] = intArrayList[i];
		}
		
		intArrayList = new int[size + 1];
		for (int i = 0; i < size; i++) {
			intArrayList[i] = copyIntArrayList[i];
		}
		intArrayList[size] = value;
		
		return true;
	}

/** Methode zum Hinzufügen eines Wertes in eine gewünschte Stelle des Arrays
  * @param index ist der Index des Wertes, der hinzugefügt werden soll
  * @param value ist der Wert, der hinzugefügt werden soll
*/	
	public void add(int index, Integer value) {
		int size = size();
		if (index >= size) {
			add(value);
			return;
		}
		int[] copyIntArrayList = new int[size];
		for (int i = 0; i < size; i++) {
			copyIntArrayList[i] = intArrayList[i];
		}
		
		intArrayList = new int[size + 1];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				++j;
			}
			intArrayList[j] = copyIntArrayList[i];
			j++;
		}
		intArrayList[index] = value;
	}

/** Methode zum Entfernen eines Wertes aus dem Array
  * @param value ist der Wert, der hinzugefügt werden soll
  * @return 0 wenn es diesen Wert nicht gibt ,
  * und 1 wenn es diesen Wert gibt und es erfolgreich entfernt wurde
*/	
	public Integer remove(int value) {
		if (!contains(value)) {
			System.out.println("Das zu entfernende Element existiert nicht.");
			return 0;
		} else {
			int index = get(value);
			int reducedSize = size() - 1;
			int[] copyIntArrayList = new int[reducedSize];
			int j = 0;
			for (int i = 0; i < reducedSize; i++) {
				if (i == index) {
					++j;
				}
				copyIntArrayList[i] = intArrayList[j];
				j++;
			}
			intArrayList = new int[reducedSize];
			for (int i = 0; i < reducedSize; i++) {
				intArrayList[i] = copyIntArrayList[i];
			}	
		
			return 1;
		}
	}

/** Methode zum Löschen des Arrays
*/	
	public void clear() {
		for (int i = 0; i < size(); i++) {
			intArrayList[i] = 0;
		}
		intArrayList = new int[0];
		
	}

/** get-Methode des Arrays
  * @param value ist der Wert, dessen index geget werden soll
  * @return -69, falss es diesen Wert nicht gibt, 
  * oder der Index des Wert, falls doch
*/		
	public Integer get(int value) {
		if (!contains(value)) {
			return -69;
		}
		int size = size();
		for (int i = 0; i < size; i++) {
			if (intArrayList[i] == value) {
				return i;
			}
		}
		return -69;
	}

/** Dummy-Methode
  * @param fromIndex formIndex
  * @param toIndex toIndex
  * @return this
*/
	public List<Integer> subList(int fromIndex, int toIndex) {
		return this;
	}

/** Dummy-Methode
  * @return null null
*/	
	public ListIterator<Integer> listIterator() {
		return null;
	}

/** Dummy-Methode
  * @param index index
  * @return null null
*/	
	public ListIterator<Integer> listIterator(int index) {
		return null;
	}

/** Dummy-Methode
  * @param o o
  * @return -69 nice
*/	
	public int lastIndexOf(Object o) {
		return -69;
	}

/** Dummy-Methode
  *@param o o
  * @return -69 nice
*/	
	public int indexOf(Object o) {
		return -69;
	}

/** Dummy-Methode
  * @param index index
  * @param element element
  * @return -69 nice
*/	
	public Integer set(int index, Integer element) {
		return -69;
	}

/** Dummy-Methode 
  * @param c c
  * @return false false
*/	
	public boolean retainAll(Collection<?> c) {
		return false;
	}

/** Dummy-Methode
  * @param c c
  * @return false false
*/	
	public boolean removeAll(Collection<?> c) {
		return false;
	}

/** Dummy-Methode
  * @param c c
  * @return false false
*/	
	public boolean addAll(Collection<? extends Integer> c) {
		return false;
	}

/** Dummy-Methode
  * @param index index
  * @param c c
  * @return false false
*/	
	public boolean addAll(int index, Collection<? extends Integer> c) {
		return false;
	}

/** Dummy-Methode
  * @param c c
  * @return false false
*/	
	public boolean containsAll(Collection<?> c) {
		return false;
	}

/** Dummy-Methode
  * @param o o
  * @return false false
*/		
	public boolean remove(Object o) {
		return false;
	}

/** Dummy-Methode
  * @param <Integer> keine Ahnung
  * @param i i
  * @return null null
*/		
	public <Integer> Integer[] toArray(Integer[] i) {
		return null;
	}

/** Dummy-Methode
  * @return null null
*/	
	public Object[] toArray() {
		return null;
	}

/** Dummy-Methode
  * @return null null
*/	
	public Iterator<Integer> iterator() {
		return null;
	}
}