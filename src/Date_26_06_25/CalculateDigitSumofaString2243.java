package Date_26_06_25;

public class CalculateDigitSumofaString2243 {
    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        System.out.println(new CalculateDigitSumofaString2243().digitSum(s, k));
    }
    public String digitSum(String s, int k) {
        //keep repeating until s.length == k
        while(s.length() > k){
            StringBuilder temp = new StringBuilder(); // new stringbuilder.
            for (int i = 0; i < s.length(); i += k){
                int sum = 0;
                for (int j = i; j < Math.min(i + k, s.length()); j++){
                    sum += s.charAt(j) - '0';
                }
                temp.append(sum);
            }
            s = temp.toString();
        }
        return s;
    }
}
