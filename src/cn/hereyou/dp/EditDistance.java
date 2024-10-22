package cn.hereyou.dp;

/**
 *
 * [72]编辑距离  这题不太清楚
 */
public class EditDistance {


    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        word1 = ' ' + word1; //添加空格
        word2 = ' ' + word2;
        int[][] f = new int[n + 10][m + 10];
        for(int i = 0;i <= n;i++) f[i][0] = i; //i次删除
        for(int i = 0;i <= m;i++) f[0][i] = i; //i次删除 word1 -> word2
        for(int i = 1;i <= n;i++)
            for(int j = 1;j <= m;j++)
            {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1); //添加或者删除
                if(word1.charAt(i) == word2.charAt(j)) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);//替换
            }
        return f[n][m];
    }

    public static void main(String[] args) {

        EditDistance editDistance=new EditDistance();
        int a= editDistance.minDistance("intention","execution");
        System.out.printf(String.valueOf(a));
    }
}
