//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2786 👎 0

package cn.felix.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String str0 = strs[0];
        for (int i = 0; i < str0.length(); i++) {
            char c = str0.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (str.length()<=i || str.charAt(i) != c){
                    return str0.substring(0,i);
                }
            }
        }
        return str0;
    }

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(new String[]{"123","123","123"}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
