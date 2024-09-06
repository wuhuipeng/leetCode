package cn.hereyou.hash;


import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 *
 *
 *
 *[49]. 字母异位词分组
 *
 *
 *
 *给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 */

public class LetterGrouping {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strToListMap.computeIfAbsent(String.valueOf(chars), key -> new ArrayList<>()).add(str);
        }
        return strToListMap.values().stream().collect(Collectors.toList());
    }

}
