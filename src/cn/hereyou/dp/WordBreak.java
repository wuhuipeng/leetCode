package cn.hereyou.dp;


import java.util.List;
import java.util.Set;

/**
 *
 *
 *
 */
public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        // 创建一个 DP 数组
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;  // 空字符串是可以被拼接出来的

        // 将 wordDict 转换为集合，方便查询
        Set<String> wordSet = new HashSet<>(wordDict);

        // 填充 DP 数组
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    // 主函数用于测试
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();

        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        boolean result = wb.wordBreak(s, wordDict);
        System.out.println(result);  // 输出: true
    }
}
