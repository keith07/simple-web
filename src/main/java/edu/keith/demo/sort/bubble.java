package edu.keith.demo.sort;

public class bubble  {

	public static void sort(int[] ints){
		for(int i = 1; i < ints.length; i++){
			if(ints[i-1] > ints[i]){
				int swap = ints[i];
				ints[i] = ints[i-1];
				ints[i-1] = swap;
			}
		}
	}
	
	public static void main(String[] args){
		int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		//二分插入排序
		efcz.sort(a);
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
