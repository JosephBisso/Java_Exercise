import java.util.*;
public class IntArrayList implements List<Integer> {
	
	public static void main(String[] args) {
		IntArrayList intArray = new IntArrayList();
		System.out.println("Erste Ausgabe der Liste : " + intArray.toString()); 
		intArray.toString();
		System.out.println("Size : " + intArray.size());
		System.out.println("Leer ? : " + intArray.isEmpty());
		intArray.add(3);
		intArray.add(5);
		intArray.add(2, 15);
		System.out.println("Zweite Ausgabe der Liste : " + intArray.toString()); 
		intArray.remove(15);
		System.out.println("Dritte Ausgabe der Liste : " + intArray.toString()); 
		intArray.clear();
		System.out.println("Letzte Ausgabe der Liste : " + intArray.toString()); 
	}
	
	private int[] intArrayList;
	
	public IntArrayList() {
		intArrayList = new int[1];
	}
	
/*	private IntArrayList(int[] intArrayList){
		int size = intArrayList.length;
		this.intArrayList = new int[size];
		
		for (int i = 0; i < size; i++) {
			this.intArrayList[i] = intArrayList[i];
		}
	}
*/	
	public String toString() {		
		String stringArrayList;
		int size = size();
		
		for (int i = 0; i < size; i++) {
			stringArrayList += intArrayList[i];
			
			if (i < size - 1) {
				stringArrayList += ", ";
			}
		}
		return stringArrayList;
	}
	
	public int size() {
		return intArrayList.length;
	}
	
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
	
	public boolean contains(int value) {
		for (int intValue : intArrayList) {
			if (intValue == value) {
				return true;
			}
		}
		return false;
	}
	
	public boolean add(Integer value) {
		int size = size();
		int[] copyIntArrayList = new int[size];
		for (int i = 0; i < size; i++) {
			copyIntArrayList[i] = intArrayList[i];
		}
		
		intArrayList = new int[size+1];
		for (int i = 0; i < size; i++) {
			intArrayList[i] = copyIntArrayList[i];
		}
		intArrayList[size] = value;
		
		return true;
	}
	
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
		
		intArrayList = new int[size+1];
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
				if(i == index){
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
	
	public void clear() {
		for (int i = 0; i < size(); i++) {
			intArrayList[i] = 0;
		}
	}
	
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
	}
	
	public List<Integer> subList(int fromIndex, int toIndex){
		return this;
	}
	
	public ListIterator<Integer> listIterator(){
		return null;
	}
	public ListIterator<Integer> listIterator(int index){
		return null;
	}
	
	public int lastIndexOf(Object o) {
		return -69;
	}
	
	public int indexOf(Object o) {
		return -69;
	}
	
	public Integer set(int index, Integer element) {
		return -69;
	}
	
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	
	public boolean removeAll(Collection<?> c) {
		return false;
	}
	
	public boolean addAll(Collection<? extends Integer> c) {
		return false;
	}
	
	public boolean addAll(int index, Collection<? extends Integer> c) {
		return false;
	}
	
	public boolean containsAll(Collection<?> c) {
		return false;
	}
	
	public boolean remove(Object o) {
		return false;
	}
}