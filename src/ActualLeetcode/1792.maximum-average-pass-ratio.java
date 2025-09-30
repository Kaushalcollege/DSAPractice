/*
 * @lc app=leetcode id=1792 lang=java
 *
 * [1792] Maximum Average Pass Ratio
 */

// @lc code=start
import java.util.*;
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        /*
         -- How exactly to calculate the increase in pass ratio when adding an extra student?
         -- The increase in pass ratio when adding an extra student to a class with p passing students and t total students is:
         -- (p + 1) / (t + 1) - p / t
         -- = (pt + t - pt + p) / (t(t + 1))
         -- = (t + p) / (t(t + 1))
         -- = (1 + p / t) / (t + 1)
         -- = (1 + current pass ratio) / (t + 1)
         -- This means that the increase in pass ratio is higher for classes with a lower total number of students.
         -- Therefore, we should prioritize adding extra students to classes with a lower total number of students.
         -- We can use a max heap to always add an extra student to the class that will yield the highest increase in pass ratio.
         */
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[0] < b[0]) return 1;
                if (a[0] > b[0]) return -1;
                return 0;
            }
        });

        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
            extraStudents--;
        }

        double sum = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] c = (double[]) arr[i];
            sum += c[1] / c[2];
        }

        return sum / classes.length;
    }
}
// @lc code=end

