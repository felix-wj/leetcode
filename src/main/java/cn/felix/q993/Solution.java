package cn.felix.q993;

import java.util.*;

/**
 * @Author 王杰
 * @Description 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/5/17
 **/
public class Solution {
	public boolean isCousins(TreeNode root, int x, int y) {

		List<TreeNode> treeNodes = new ArrayList<TreeNode>(6);
		treeNodes.add(root);
		if (root.val == x || root.val == y){
			return false;
		}
		while (!treeNodes.isEmpty()){
			List<TreeNode> tempNodes = new ArrayList<TreeNode>(6);
			boolean isX = false;
			boolean isY = false;
			for (TreeNode treeNode : treeNodes) {
				if (treeNode != null){
					if (x == treeNode.val){
						isX = true;
					}else if (y == treeNode.val){
						isY =true;
					}
					if (treeNode.left != null){
						if (treeNode.right != null){
							if ((x==treeNode.left.val && y == treeNode.right.val) || (x==treeNode.right.val && y==treeNode.left.val)){
								return false;
							}else {
								tempNodes.add(treeNode.left);
								tempNodes.add(treeNode.right);
							}
						}else {
							tempNodes.add(treeNode.left);
						}
					}else if (treeNode.right != null){
						tempNodes.add(treeNode.right);
					}
				}
			}
			if (isY ^ isX){
				return false;
			}
			if (isY){
				return true;
			}

			treeNodes = tempNodes;
		}
		return false;


	}

	class TreeNode {
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
	}
}
