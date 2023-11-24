//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1260 👎 0

package cn.felix.leetcode.editor.cn;

class PalindromicSubstrings {
	public static void main(String[] args) {
		Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("aaa"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int countSubstrings(String s) {
            if (s.length() == 1){
                return 1;
            }
            char[] sc = new char[s.length()*2+1];
            for (int i = 0; i < s.length(); i++) {
                sc[2*i]='#';
                sc[2*i+1]=s.charAt(i);
            }
            sc[sc.length-1]='#';
            int total = 0;
            int[] lens = new int[sc.length];
            int right = -1,c=0,leftI,len;
            for (int i = 0; i < sc.length; i++) {
                if (right>=i){
                    leftI = 2*c-i;
                    len = Math.min(lens[leftI],right-i+1);
                    len = expand(sc,i-len,i+len);
                }else {
                    len = expand(sc,i,i);
                }
                lens[i]=len;
                if (i+len>right){
                    c = i;
                    right = i+len;
                }
                for (int j = i; j <=len+i ; j++) {
                    if (sc[j]!='#'){
                        total++;
                    }
                }
            }
            return total;
		}
        private int expand(char[] sc,int l,int r){
            while (l>=0 && r<sc.length && sc[l] == sc[r]){
                l--;
                r++;
            }
            return (r-l-2)/2;
        }
	}

//leetcode submit region end(Prohibit modification and deletion)

}