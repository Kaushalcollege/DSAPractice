package LeetCode.Date_23_05_25;

public class SumofDigitsofStringAfterConvert1945 {
    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        System.out.println(new SumofDigitsofStringAfterConvert1945().getLucky(s, k));
    }
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append((int)(c - 'a') + 1);
        return transform(sb.toString(), k);
    }
    public int transform(String numStr, int k) {
        if (k == 0) return Integer.parseInt(numStr);
        int sum = 0;
        for (char digit : numStr.toCharArray()) sum += digit - '0';
        return transform(String.valueOf(sum), k - 1);
    }
}
