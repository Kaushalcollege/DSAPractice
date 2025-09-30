package LeetCode.dailychallenges;
// 27-05-25
public class DivisibleandNondivisibleSumsDifference2894 {
    public static void main(String[] args) {
        int n = 5, m = 6;
        System.out.println(new DivisibleandNondivisibleSumsDifference2894().differenceOfSums(n, m));   
    }
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++){
            if (i % m != 0) num1 += i;
            else num2 += i;
        }
        return num1 - num2;
    }
}
