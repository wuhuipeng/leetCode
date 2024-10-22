package cn.hereyou.backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * [22] 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current, int open, int close, int max) {
        // 如果当前字符串的长度等于 2*n，则将其加入结果
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 如果左括号的数量小于 n，添加左括号
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }

        // 如果右括号的数量小于左括号的数量，添加右括号
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        int n = 3; // 这里可以修改 n 的值
        List<String> combinations = gp.generateParenthesis(n);
        System.out.println(combinations);
    }
}
