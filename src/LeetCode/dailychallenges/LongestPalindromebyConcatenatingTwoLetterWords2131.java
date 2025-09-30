package LeetCode.dailychallenges;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromebyConcatenatingTwoLetterWords2131 {
    public static void main(String[] args) {
        String[] words = {"ab","ty","yt","lc","cl","ab"};
        System.out.println(new LongestPalindromebyConcatenatingTwoLetterWords2131().longestPalindrome(words));
    }
    public int longestPalindrome(String[] words) {
        int count = 0;
        Map<String, Integer> ii = new HashMap<>();
        for (String word : words){
            ii.put(word, ii.getOrDefault(word, 0) + 1);
        }
        boolean centre = false;
        System.out.println(ii);
        for (String twoletterword : ii.keySet()){
            System.out.println(ii);
            System.out.println(twoletterword);
            System.out.println(count);
            String hello = new StringBuilder(twoletterword).reverse().toString();
            System.out.println(hello.toString());
            if (twoletterword.equals(hello)){
                int minimum = ii.get(twoletterword) / 2;
                count += minimum * 4;
                ii.put(twoletterword, ii.get(twoletterword) - (minimum * 2));
                if (!centre && ii.get(twoletterword) > 0) {
                    count += 2;
                    centre = true;
                    System.out.println(count);
                }
            }
            // System.out.println(hello);
            else if (ii.containsKey(hello)){
                int minimum = Math.min(ii.get(twoletterword), ii.get(hello));
                count = count + (minimum * 4);
                ii.put(twoletterword, ii.get(twoletterword) - minimum);
                ii.put(hello, ii.get(hello) - minimum);
                System.out.println(count);
            }
            else continue;
        }
        return count;
    }
}
// the centre part is a bit frustrating.