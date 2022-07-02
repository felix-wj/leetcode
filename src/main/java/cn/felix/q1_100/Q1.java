package cn.felix.q1_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 王杰
 * @Description   两数之和
 * https://leetcode.cn/problems/two-sum/
 * @Date 2022/7/2
 **/
public class Q1 {

	public static void main(String[] args) {
		int[] nums = new int[]{2,7,11,15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0;i<nums.length;i++) {
			Integer key = target - nums[i] ;
			Integer idx = map.get(key);
			if (idx != null){
				return new int[]{idx,i};
			}
			map.put(nums[i],i);
		}
		throw new RuntimeException("未找到合适的组合");
	}
}
