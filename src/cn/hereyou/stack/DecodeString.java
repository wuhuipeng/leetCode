package cn.hereyou.stack;

import java.util.Stack;

/**
 * [394]
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class DecodeString {
    public static String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果是数字，构造k
                k = k * 10 + c - '0';
            } else if (c == '[') {
                // 如果遇到 '['，将当前的字符串和k存入栈中
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // 如果遇到 ']'，弹出栈顶元素并解码
                StringBuilder decodedString = stringStack.pop();
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // 如果是字符，直接追加到当前字符串
                currentString.append(c);
            }
        }

        return currentString.toString();
    }


    public static void main(String[] args) {
        String encodedString = "3[a2[c]]";
        String decodedString = decodeString(encodedString);
        System.out.println(decodedString);  // 输出 "aaabcbc"
    }

}
