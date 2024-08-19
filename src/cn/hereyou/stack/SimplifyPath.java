package cn.hereyou.stack;

import java.util.Stack;

/**
 * [71]简化路径
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        // 使用栈来存储目录名
        Stack<String> stack = new Stack<>();

        // 分割路径为多个部分
        String[] components = path.split("/");

        // 处理路径的每个部分
        for (String component : components) {
            // 如果遇到 ".."，返回上一级目录（即弹出栈顶元素）
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // 忽略 "." 或空字符串
            } else if (!component.equals("") && !component.equals(".")) {
                stack.push(component);
            }
        }

        // 构建简化后的路径
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // 如果栈是空的，返回根目录 "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home/"));                // 输出: "/home"
        System.out.println(sp.simplifyPath("/../"));                  // 输出: "/"
        System.out.println(sp.simplifyPath("/home//foo/"));           // 输出: "/home/foo"
        System.out.println(sp.simplifyPath("/a/./b/../../c/"));       // 输出: "/c"
    }
}
