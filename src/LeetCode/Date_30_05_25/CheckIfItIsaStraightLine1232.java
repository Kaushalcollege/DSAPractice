package LeetCode.Date_30_05_25;

public class CheckIfItIsaStraightLine1232 {
    public static void main(String[] args) {
        int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        System.out.println(new CheckIfItIsaStraightLine1232().checkStraightLine(coordinates));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        int x1 = coordinates[0][0], x2 = coordinates[1][0];
        int y1 = coordinates[0][1], y2 = coordinates[1][1];
        double slope = 0;
        if ((x2 - x1) != 0) slope = (double)(y2 - y1)/(x2 - x1);
        else slope = Double.POSITIVE_INFINITY;
        for (int i = 1; i < coordinates.length - 1; i++){
            int xi = coordinates[i][0], xj = coordinates[i + 1][0];
            int yi = coordinates[i][1], yj = coordinates[i + 1][1];
            System.out.println("row " + xi + " " + xj + " " + yi + " " + yj);
            double slope1 = 0;
            if ((xj - xi) != 0) slope1 = (double)(yj - yi)/(xj - xi);
            else slope1 = Double.POSITIVE_INFINITY;
            System.out.println(slope1);
            if (slope1 != slope) return false;
        }
        return true;
    }
}
