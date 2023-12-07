//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
// 
// 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 990 👎 0

package cn.felix.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class SubtreeOfAnotherTree {
	public static void main(String[] args) {

		Solution solution = new SubtreeOfAnotherTree().new Solution();
		SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
		TreeNode root = subtreeOfAnotherTree.getTree("3,4,5,1,2,null,null,null,null,0");
		TreeNode subRoot = subtreeOfAnotherTree.getTree("4,1,2");
		System.out.println(solution.isSubtree(root,subRoot));
	}

	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {
		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			return dfs(root,subRoot);
		}

		public boolean dfs(TreeNode s,TreeNode t){
			if (s == null){
				return false;
			}
			return check(s,t) || dfs(s.left,t) || dfs(s.right,t);
		}

		public boolean check(TreeNode root, TreeNode subRoot) {
			if (subRoot == null && root == null) {
				return true;
			}
			if (root == null || subRoot == null) {
				return false;
			}
			return root.val == subRoot.val && check(root.left, subRoot.left) && check(root.right, subRoot.right);
		}

	}

	//leetcode submit region end(Prohibit modification and deletion)
	public TreeNode getTree(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		String[] splits = data.split(",");
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode();
		root.val = Integer.parseInt(splits[0]);
		queue.offer(root);
		for (int i = 1; i < splits.length; i = i + 2) {
			TreeNode parentNode = queue.poll();
			if (parentNode != null) {
				if (splits[i].equals("null")) {
					queue.offer(null);
				} else {
					TreeNode left = new TreeNode();
					left.val = Integer.parseInt(splits[i]);
					parentNode.left = left;
					queue.offer(left);
				}
				if (i+1<splits.length) {


					if (splits[i + 1].equals("null")) {
						queue.offer(null);
					} else {
						TreeNode right = new TreeNode();
						right.val = Integer.parseInt(splits[i+1]);
						parentNode.right = right;
						queue.offer(right);
					}
				}
			} else {
				queue.offer(null);
				queue.offer(null);
			}
		}
		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		public TreeNode getTree(String data) {
			if (data == null || data.isEmpty()) {
				return null;
			}
			String[] splits = data.split(",");
			Queue<TreeNode> queue = new LinkedList<>();
			TreeNode root = new TreeNode();
			root.val = Integer.parseInt(splits[0]);
			queue.offer(root);
			for (int i = 1; i < splits.length; i = i + 2) {
				TreeNode parentNode = queue.poll();
				if (parentNode != null) {
					if (splits[i].equals("null")) {
						queue.offer(null);
					} else {
						TreeNode left = new TreeNode();
						parentNode.left = left;
						queue.offer(left);
					}
					if (splits[i + 1].equals("null")) {
						queue.offer(null);
					} else {
						TreeNode right = new TreeNode();
						parentNode.right = right;
						queue.offer(right);
					}
				} else {
					queue.offer(null);
					queue.offer(null);
				}
			}
			return root;
		}
	}
}