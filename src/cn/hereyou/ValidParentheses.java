package cn.hereyou;

import java.util.Stack;

/**
 * 第20题
 */
public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {

        //1.为空或奇数直接跳过
        if(s.isEmpty() || s.length() % 2 == 1) {
            return false;
        }
        //2.创建辅助栈
        Stack<Character> stack = new Stack<>();
        //3.遍历
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        //4.返回
        return stack.isEmpty();
    }


}
