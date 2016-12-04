package edu.keith.demo.sort;

/**
 * 二分查找方式排序
 * @author keith
 *
 */
public class efcz {

	public static void sort(int[] ints){
		for(int i =0; i < ints.length; i++){
			int left = 0;
			int right = i-1;
			int mid = 0;
			int swap = ints[i];
			while(left <= right){
				mid = (left + right)/2;
				if(swap < ints[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
			for(int j = i-1; j >= left; j--){
				ints[j+1] = ints[j];
			}
			if(left != i)
				ints[left] = swap;
		}
		
	}
	
	public static void main(String[] args){
		Integer i1=129;
		Integer i2=129;
		System.out.println(i1==i2);
		
		
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
