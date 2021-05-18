package cn.felix.q1442;

import java.util.*;

public class Solution {

	public int countTriplets1(int[] arr) {
		int count = 0;
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			temp = temp^arr[i];
			arr[i] = temp;
			if (temp == 0){
				count = count+i;
			}
			for (int i1 = 0; i1 < i-1; i1++) {
				if ((temp ^ arr[i1])==0){
					count = count+(i-i1-1);
				}
			}
		}
		return count;
	}
	public int countTriplets2(int[] arr) {
		int count = 0;
		int temp = 0;
		Map<Integer, List<Integer>> s = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			temp = temp^arr[i];
			if (temp == 0 ){
				count = count+i;
			}
			List<Integer> integers = s.computeIfAbsent(temp, k->new ArrayList<>());
			for (Integer integer : integers) {
				count += i-integer-1;
			}
			integers.add(i);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {7,11,12,9,5,2,7,17,22};
		Solution solution = new Solution();
		System.out.println(solution.countTriplets1(arr));
	}
}
