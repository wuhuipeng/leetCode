package cn.hereyou.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 [207]. 课程表
 中等
 相关标签
 相关企业
 提示
 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 记录访问状态：0 - 未访问，1 - 正在访问，2 - 已访问
        int[] visited = new int[numCourses];

        // DFS 检测环
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(graph, visited, i)) {
                return false; // 如果发现环路，返回 false
            }
        }
        return true; // 如果没有环路，返回 true
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return true; // 当前正在访问中，发现环
        }
        if (visited[course] == 2) {
            return false; // 已访问，无需再次访问
        }

        // 标记为正在访问
        visited[course] = 1;

        // 遍历所有依赖的课程
        for (int nextCourse : graph.get(course)) {
            if (hasCycle(graph, visited, nextCourse)) {
                return true; // 递归检测环
            }
        }

        // 标记为已访问
        visited[course] = 2;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 3;
        int[][] prerequisites = {{1, 0},{1, 2},{0,2}};
        System.out.println(cs.canFinish(numCourses, prerequisites)); // 输出: true
    }

}
