package cn.felix.q1738;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Author 王杰
 * @Description
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/19
 **/
public class Solution {
	Random random = new Random();
	public int kthLargestValue(int[][] matrix, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int m = matrix.length;
		int n = matrix[0].length;
		addToHeap(minHeap,matrix[0][0],k);
		for (int i = 1; i < n; i++) {
			matrix[0][i] ^= matrix[0][i-1];
			addToHeap(minHeap,matrix[0][i],k);
		}
		for (int i = 1; i < m; i++) {
			matrix[i][0] ^= matrix[i-1][0];
			addToHeap(minHeap,matrix[i][0],k);
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i-1][j] ^ matrix[i][j-1] ^ matrix[i-1][j-1]^ matrix[i][j];
				addToHeap(minHeap,matrix[i][j],k);
			}
		}

		return minHeap.peek();

	}

	private void addToHeap(PriorityQueue<Integer> minHeap, int value,int k) {
		if (minHeap.isEmpty() || minHeap.size()<k){
			minHeap.add(value);
		}else if (minHeap.peek()<value){
			minHeap.poll();
			minHeap.add(value);
		}
	}

	private int quickSelect(int[] a,int l,int r,int index){
		int q = halfPartition(a,l,r);
		if (q == index){
			return a[q];
		}else {
			return q>index? quickSelect(a,l,q-1,index): quickSelect(a,q+1,r,index);
		}

	}

	private int halfPartition(int[] a, int l, int r) {
		int i = random.nextInt(r-l+1)+l;
		swap(a,i,r);
		return partition(a,l,r);
	}

	private int partition(int[] a, int l, int r) {
		int t = a[r];
		int i = l-1;
		for (int j = l; j < r; j++) {
			if (a[j]<=t){
				swap(a,++i,j);
			}
		}
		swap(a,++i,r);
		return i;
	}

	private void swap(int[] a, int i, int r) {
		int temp = a[i];
		a[i] = a[r];
		a[r]=temp;
	}

	public static void main(String[] args) {
		int[][] s = {{5,2},{1,6}};
		Solution solution = new Solution();
		System.out.println(solution.kthLargestValue(s,2));
	}
}
