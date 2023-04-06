package cn.hereyou;

import java.util.*;

/**
 * 17. 电话号码的字母组合 广度优先算法
 */

public class LetterCombinationsOfAPhoneNumber {


    public static List<String> letterCombinations(String digits, Map<Character, String[]> phoneMap) {
        List<String> combinations = new ArrayList<String>();// 使用一个集合来存储所有的字母组合结果
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String[]> phoneMap, String digits, int index,
                                 StringBuffer combination) {
        // index 的取值是回溯的关键，非常需要注意
        if (index == digits.length()) {// 一次深度遍历结束跳出，将收集到的值返回给combinations
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String[] letters = phoneMap.get(digit);

            for (String letter : letters) {
                combination.append(letter);
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        // 将号码字母对应关系存储进Map
        Map<Character, String[]> phoneMap = new HashMap<Character, String[]>() {
            { // 存储为数组更好操作
                put('0', new String[] {});
                put('1', new String[] {});
                put('2', new String[] { "a", "b", "c" });
                put('3', new String[] { "d", "e", "f" });
                put('4', new String[] { "g", "h", "i" });
                put('5', new String[] { "j", "k", "l" });
                put('6', new String[] { "m", "n", "o" });
                put('7', new String[] { "p", "q", "r", "s" });
                put('8', new String[] { "t", "u", "v" });
                put('9', new String[] { "w", "x", "y", "z" });
            }
        };

        System.out.println("请输入一个字符串，其中仅包含数字2-9：");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        List<String> result = letterCombinations(str, phoneMap);
        System.out.println(result);

    }

}
