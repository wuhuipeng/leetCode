package cn.hereyou;

/**
 * 第14题
 */
public class LongesCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


}
