package cn.felix.q421;

/**
 * @Author 王杰
 * @Description 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：nums = [8,10,2]
 * 输出：10
 * 示例 5：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 0 <= nums[i] <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/16
 **/
public class XOR {

	public int findMaximumXOR(int[] nums) {
		Trie root = new Trie();

		for (int num : nums) {
			Trie temp = root;
			for (int i = 30; i >= 0; i--) {
				if (1 == (num >> i & 1)) {
					if (temp.getRight() == null) {
						temp.setRight(new Trie());
					}
					temp = temp.getRight();

				} else {
					if (temp.getLeft() == null) {
						temp.setLeft(new Trie());
					}
					temp = temp.getLeft();
				}
			}
		}
		int max = 0;
		for (int num : nums) {
			Trie temp = root;
			int m = 0;
			for (int i = 30; i >= 0; i--) {
				if (1 == (num >> i & 1)) {
					if (temp.getLeft() != null) {
						m = m ^ (1 << i);
						temp = temp.getLeft();
					} else if (temp.getRight() != null) {
						temp = temp.getRight();
					} else {
						break;
					}
				} else {
					if (temp.getRight() != null) {
						m = m ^ (1 << i);
						temp = temp.getRight();
					} else if (temp.getLeft() != null) {
						temp = temp.getLeft();
					} else {
						break;
					}
				}
			}
			max = Math.max(max, m);
		}
		return max;
	}


	class Trie {
		private Trie left;
		private Trie right;

		public Trie getLeft() {
			return left;
		}

		public void setLeft(Trie left) {
			this.left = left;
		}

		public Trie getRight() {
			return right;
		}

		public void setRight(Trie right) {
			this.right = right;
		}
	}

	public static void main(String[] args) {
		XOR xor = new XOR();
		int a[] = {2};
		System.out.println(xor.findMaximumXOR(a));
	}
}
