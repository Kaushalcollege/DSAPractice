import java.util.*;
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring76().minWindow(s, t));
    }

    public static String minWindow(String s, String t){

        // creating my window checker.
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // updating all the elements to target map.
        for (char c : t.toCharArray()){
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; // sliding window.
        int minLength = Integer.MAX_VALUE;
        int minStart = 0; // starting index of the minimum length substring.
        int formed = 0; // how many characters within the current window matched;
        int required = t.length();

        while(right < s.length()){ // expanding window to the right.

            char c = s.charAt(right);

            if (target.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) <= target.get(c)) formed++;
            }

            //shrinking the window:
            while(formed == required){
                //
                if (right - left + 1 < minLength){
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                if (target.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                    if (window.get(leftChar) < target.get(leftChar)) formed--;
                }

                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
