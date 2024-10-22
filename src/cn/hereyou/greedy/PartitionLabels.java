package cn.hereyou.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 763. 划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 *
 */
public class PartitionLabels {

    public static void main(String[] args) {

    }
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            pos[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int pre = -1, i = 0, bound = 0;
        while (i < len) {
            if (i <= bound) {
                bound = Math.max(bound, pos[S.charAt(i) - 'a']);
            }
            if (i == bound) {
                res.add(i - pre);
                pre = i;
                bound++;
            }
            i++;
        }
        return res;
    }
}
