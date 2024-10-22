package cn.hereyou.area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * [56. 合併區間]
 */
public class MergeArea {

    public int[][] merge(int[][] intervals) {
        // 如果区间数组为空或者长度为 0，返回空数组
        if (intervals == null || intervals.length == 0) return new int[0][0];

        // 按照区间的左端点从小到大排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 创建一个结果数组用于存储不重叠区间
        List<int[]> res = new ArrayList<>();

        // 当前区间初始值设置为第一个区间
        int[] cur = intervals[0];

        // 遍历整个区间数组
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的右端点大于等于下一个区间的左端点，则更新当前区间的右端点
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 否则把当前区间加入到结果数组中
                res.add(cur);
                // 并将当前区间更新为下一个区间
                cur = intervals[i];
            }
        }
        // 把最后一个区间加入到结果数组中
        res.add(cur);

        // 将结果数组转换为 int[][] 类型并返回
        return res.toArray(new int[res.size()][2]);
    }
}
