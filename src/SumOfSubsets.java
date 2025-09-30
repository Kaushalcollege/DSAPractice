import java.util.*;

public class SumOfSubsets {
    
    static void subsetSum(int[] S, int n, int i, int currentSum, int remainingSum, List<Integer> solution, int M) {
        // Found a valid subset
        if (currentSum == M) {
            System.out.println(solution);
            return;
        }

        // Prune: no more elements OR sum already too large OR can't reach target
        if (i == n || currentSum + remainingSum < M || currentSum > M) {
            return;
        }

        // Choice 1: include S[i]
        solution.add(S[i]);
        subsetSum(S, n, i + 1, currentSum + S[i], remainingSum - S[i], solution, M);
        solution.remove(solution.size() - 1);  // Backtrack

        // Choice 2: exclude S[i]
        subsetSum(S, n, i + 1, currentSum, remainingSum - S[i], solution, M);
    }

    public static void main(String[] args) {
        int[] S = {5, 10, 12, 13, 15, 18};
        int n = S.length;
        int M = 30;

        // Total sum for pruning
        int totalSum = 0;
        for (int num : S) {
            totalSum += num;
        }

        List<Integer> solution = new ArrayList<>();
        subsetSum(S, n, 0, 0, totalSum, solution, M);
    }
}
