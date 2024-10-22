package cn.hereyou.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [387]387. 字符串中的第一个唯一字符
 */
public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        // 统计字符频率
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            queue.offer(c);
        }

        // 查找第一个唯一字符
        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (charCount.get(current) == 1) {
                return s.indexOf(current);
            }
        }

        return -1; // 如果没有唯一字符
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1)); // 输出: 0

        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2)); // 输出: 2

        String s3 = "aabb";
        System.out.println(firstUniqChar(s3)); // 输出: -1
    }
}
