package cn.hereyou.stack;


import java.util.Stack;

/**
 * [844] 比较含退格的字符串
 *
 */
public class CompareStringsWithBackspace {

    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(backspaceCompare(s1, s2)); // 输出：true

        String s3 = "ab##";
        String s4 = "c#d#";
        System.out.println(backspaceCompare(s3, s4)); // 输出：true

        String s5 = "a#c";
        String s6 = "b";
        System.out.println(backspaceCompare(s5, s6)); // 输出：false
    }

    public static boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private static String processString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop(); // 退格，弹出栈顶元素
                }
            } else {
                stack.push(ch); // 正常字符，入栈
            }
        }

        // 构建最终字符串
        StringBuilder processedString = new StringBuilder();
        while (!stack.isEmpty()) {
            processedString.append(stack.pop());
        }

        return processedString.reverse().toString(); // 反转字符串返回
    }
}
