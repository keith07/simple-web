package edu.keith.demo.sort;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by keith on 2017/3/26.
 */
public abstract class Sorter<T extends Comparable<T>> {
	public abstract T[] sort(T[] array);

	public int compare(T t1, T t2) {
		return t1.compareTo(t2);
	}

	public void swap(T[] array, int fromIndex, int toIndex) {
		Assert.assertNotNull(array);
		int size = array.length;
		Assert.assertTrue(fromIndex >= 0 && fromIndex < size);
		Assert.assertTrue(toIndex >= 0 && toIndex < size);

		T swapper = array[toIndex];
		array[toIndex] = array[fromIndex];
		array[fromIndex] = swapper;
	}

	public void swap(List<T> list, int fromIndex, int toIndex) {
		Assert.assertNotNull(list);
		int size = list.size();
		Assert.assertTrue(fromIndex >= 0 && fromIndex < size);
		Assert.assertTrue(toIndex >= 0 && toIndex < size);

		T swapper = list.get(toIndex);
		list.set(toIndex,list.get(fromIndex));
		list.set(fromIndex, swapper);
	}

	public static void main(String[] args){

		Integer[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
//		Sorter<Integer> sorter = new BubbleSorter<>();
//		Sorter<Integer> sorter = new InsertSorter<>();
		Sorter<Integer> sorter = new QuickSorter<>();
		//二分插入排序
		sorter.sort(a);
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}

class BubbleSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	public T[] sort(T[] array) {
		Assert.assertNotNull(array);

		int size = array.length;
		while (size >= 2) {
			swapWithCompare(array, size - 2, size - 1);
			size--;
		}
		return array;
	}

	private T[] swapWithCompare(T[] array, int index1, int index2) {
		if (index1 > 0) {
			array = swapWithCompare(array, index1-1, index2-1);
		}
		if (array[index1].compareTo(array[index2]) > 0) {
			swap(array, index1, index2);
		}
		return array;
	}
}

class InsertSorter<T extends Comparable<T>> extends Sorter<T> {
	@Override
	public T[] sort(T[] array) {
		Assert.assertNotNull(array);

		List<T> list = new LinkedList<>();
		int size = array.length;
		for (int i = 0; i < size; i++) {
			insertWithCompare(list, array[i]);
		}
		return list.toArray(array);
	}

	private void insertWithCompare(List<T> list, T t) {
		int size = list.size();
		if (list.size() == 0) {
			list.add(t);
			return;
		}
		for (int i = 0; i < size; i++) {
			if (list.get(i).compareTo(t) > 0) {
				list.add(i, t);
				return;
			}
		}
		list.add(t);
		return;
	}
}

class QuickSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	public T[] sort(T[] array) {
		List<T> list = new LinkedList<>();
		for(int i = 0; i < array.length;i++) {
			list.add(array[i]);
		}
		sortPart(list, 0, array.length - 1);
		return list.toArray(array);
	}

	private void sortPart(List<T> arrays, int startIndex, int endIndex) {
		int lastIndex = startIndex;
		if (startIndex >= endIndex) {
			return;
		}
		T sign = arrays.get(startIndex);
		for (int i = startIndex + 1; i <= endIndex; i++) {
			if (sign.compareTo(arrays.get(i)) > 0) {
				swap(arrays, lastIndex++, i);
			}
		}
		sortPart(arrays, startIndex, lastIndex - 1);
		sortPart(arrays, lastIndex + 1, endIndex);
	}
}

class MergeSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	public T[] sort(T[] array) {
		// TODO: 2017/3/27
		return array;
	}
}

class SelectSorter<T extends Comparable<T>> extends Sorter<T> {

	@Override
	public T[] sort(T[] array) {
		// TODO: 2017/3/27
		return array;
	}
}