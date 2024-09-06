package cn.hereyou.bfs;


import java.util.*;

/**
 * LeetCode:[127]
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // 结束词不在字典中，无法转换
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1; // 转换序列的初始级别为1

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] wordChars = currentWord.toCharArray();

                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordChars[j] == c) {
                            continue; // 跳过和当前字符相同的情况
                        }

                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);

                        if (newWord.equals(endWord)) {
                            return level + 1; // 找到了最短转换序列
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // 避免重复访问
                        }
                    }

                    wordChars[j] = originalChar; // 恢复当前字符
                }
            }

            level++; // 进入下一级别
        }

        return 0; // 无法从 beginWord 转换到 endWord
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // 结束词不在字典中，无法转换
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        int level = 1; // 转换序列的初始级别为1

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                // 交换两个集合，始终从较小的集合开始扩展
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();

                for (int i = 0; i < wordChars.length; i++) {
                    char originalChar = wordChars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordChars[i] == c) {
                            continue; // 跳过和当前字符相同的情况
                        }

                        wordChars[i] = c;
                        String newWord = String.valueOf(wordChars);

                        if (endSet.contains(newWord)) {
                            return level + 1; // 找到了最短转换序列
                        }

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextSet.add(newWord);
                            visited.add(newWord); // 避免重复访问
                        }
                    }

                    wordChars[i] = originalChar; // 恢复当前字符
                }
            }

            beginSet = nextSet;
            level++; // 进入下一级别
        }

        return 0; // 无法从 beginWord 转换到 endWord
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder wordLadder = new WordLadder();
        int shortestLength = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("The length of the shortest conversion sequence is: " + shortestLength);
    }
}
