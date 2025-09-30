package Date_28_05_25;

import java.util.Arrays;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ii = new StringBuilder();
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++){
            if (first.charAt(i) != last.charAt(i)) return ii.toString();
            ii.append(first.charAt(i));
        }
        return ii.toString();
    }
}
