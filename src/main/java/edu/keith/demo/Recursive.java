package edu.keith.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by keith on 2017/3/24.
 */
public class Recursive {

	public static String buildMaxValue(Integer... nums) {
		Arrays.sort(nums, (o1, o2) -> compare(o1.toString(), o2.toString()));
		StringBuffer sb = new StringBuffer();
		for (int num : nums) {
			sb.append(num);
		}
		return sb.toString();
	}

	private static int compare(String o1, String o2) {
		int len1 = o1.length();
		int len2 = o2.length();
		if (len1 == len2) {
			return o2.compareTo(o1);
		}
		int minLen = Math.min(len1, len2);
		String s1 = o1, s2 = o2;
		if (len1 > len2) {
			s1 = o1.substring(0, minLen);
		} else {
			s2 = o2.substring(0, minLen);
		}
		int result = compare(s1,s2);
		if(result != 0)
			return result;
		if (len1 > len2) {
			s1 = o1.substring(minLen);
		} else {
			s2 = o2.substring(minLen);
		}
		result = compare(s1, s2);
		return result;
	}

	public static int[] turnN(int[] ints, int n, int index) {
		if(index < n)
			return ints;
		for(int i = n-1; i>=0; i--) {
			int middle = ints[index];
			ints[index--] = ints[i];
			ints[i] = middle;
		}
		return turnN(ints,n,index);
	}

	public static void printMinVal(int[] ints, int startIndex, int endIndex,int minVal) {
		int index = (startIndex+endIndex)/2;
		if (index == startIndex) {
			System.out.println("minVal:" + Math.min(minVal, Math.min(ints[startIndex],ints[endIndex])));
			return;
		}
		if (ints[index] < minVal) {
			minVal = ints[index];
			endIndex = index;
			printMinVal(ints, startIndex, endIndex, minVal);
		} else {
			startIndex = index;
			printMinVal(ints,startIndex,endIndex,minVal);
		}
	}

	public static void printAll(int maxLength) {
		char[] chars = new char[maxLength];
		while (addOne(chars, chars.length - 1)) {
			printNonZero(chars);
		}
	}

	private static boolean addOne(char[] chars, int index) {
		if (index < 0) {
			return false;
		}
		if(chars[index] == 0)
			chars[index] = '0';
		chars[index] = (char) (chars[index] + 1);
		if (chars[index] > '9') {
			chars[index] = '0';
			return addOne(chars,index-1);
		}
		return true;
	}

	private static void printNonZero(char[] chars) {
		boolean checkFirstZero = true;
		for (int i = 0; i < chars.length; i++) {
			if (!checkFirstZero || 0 != chars[i]) {
				checkFirstZero = false;
				System.out.print(String.valueOf(chars[i]));
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		System.out.println(buildMaxValue(1,9,91,919,19,191));
//		Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
//		order(ints,0,ints.length-1);
//		Arrays.sort(ints, new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return ((o1&1)<<1)-1;
//			}
//
//			@Override
//			public boolean equals(Object obj) {
//				return false;
//			}
//		});
//		print(ints);
//		int n = 2;
//		System.out.println("turn " + n);
//		ints = turnN(ints,n,ints.length-1);
//		print(ints);
//		printMinVal(ints, 0, ints.length - 1, ints[0]);
//		printAll(33);
		SimpleLinkObj obj = buildLinkObj();
		printLinkObj(obj);
		obj = reverse(obj);
		printLinkObj(obj);
	}

	private static SimpleLinkObj reverse(SimpleLinkObj obj) {
		return swap(null, obj);
	}

	private static SimpleLinkObj swap(SimpleLinkObj prevObj, SimpleLinkObj obj) {
		if (obj == null) {
			return prevObj;
		}
		SimpleLinkObj next = obj.getNext();
		obj.addNext(prevObj);
		return swap(obj,next);
	}

	public static void order(int[] ints,int startInex,int endIndex) {
		if (startInex >= endIndex) {
			return;
		}
		if (ints[startInex] % 2 > 0) {
			swap(ints, startInex, endIndex--);
		} else {
			startInex++;
		}
		order(ints,startInex,endIndex);
	}

	private static void swap(int[] ints, int index1, int index2) {
		int i = ints[index1];
		ints[index1] = ints[index2];
		ints[index2] = i;
	}

	public static void print(Integer[] ints) {
		if(ints.length < 1)
			return;
		for(int i = 0; i < ints.length -1; i++) {
			System.out.print(ints[i]+"、");
		}
		System.out.println(ints[ints.length - 1]);
	}

	private static SimpleLinkObj buildLinkObj() {
		SimpleLinkObj header = new SimpleLinkObj(-1);
		SimpleLinkObj prev = header;
		for(int i = 0;i < 10; i++) {
			SimpleLinkObj obj = new SimpleLinkObj(i);
			prev.addNext(obj);
			prev = obj;
		}
		return header;
	}
	private static void printLinkObj(SimpleLinkObj obj) {
		System.out.print(obj.getValue());
		while ((obj = obj.getNext()) != null) {
			System.out.print("," + obj.getValue());
		}
		System.out.println();
	}
}
class SimpleLinkObj{
	private int value;
	private SimpleLinkObj next;
	public SimpleLinkObj(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

	public void addNext(SimpleLinkObj next) {
		this.next = next;
	}

	public SimpleLinkObj getNext() {
		return next;
	}
}
