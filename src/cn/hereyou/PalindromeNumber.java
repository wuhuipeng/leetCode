package cn.hereyou;

/**
 * 第9题 回文数
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        isPalindrome(1231);
    }
    public static  boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }

}
