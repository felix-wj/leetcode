//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6944 👎 0
package cn.felix.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    //动态规划法
    public String longestPalindrome1(String s) {
        if (s.length()<2){
            return s;
        }
        int maxLen = 0 ,begin = 0;
        boolean[][]dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <=s.length() ; len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i+ len -1;
                if (j>=s.length()){
                    break;
                }
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (len <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1>maxLen){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    //中心扩散法
    public String longestPalindrome(String s) {
        if (s.length()<=1){
            return s;
        }
        int maxLen = 0,begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandAroundCenter(s,i,i);
            int l2 = expandAroundCenter(s,i,i+1);
            if (l2>l1){
                l1 = l2;
            }
            if (l1>maxLen){
                begin = i-(l1-1)/2;
                maxLen = l1;
            }

        }
        return s.substring(begin,begin+maxLen);
    }
    public int expandAroundCenter(String s,int cL,int cR){
        while (cL>=0 && cR<s.length() && s.charAt(cL) == s.charAt(cR) ){
            cL--;
            cR++;
        }
        return cR-cL-1;
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome("a"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
