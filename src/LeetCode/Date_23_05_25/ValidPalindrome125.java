package LeetCode.Date_23_05_25;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome125().isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        System.out.println(new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", "")).reverse().toString());
        return s.toLowerCase().replaceAll("[^a-z0-9]", "").equals(new StringBuilder(s.toLowerCase().replaceAll("[^a-z0-9]", "")).reverse().toString());
    }
}
