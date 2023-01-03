package leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] steps;
        if(n<=0){
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else{
            steps = new int[n + 1];
            steps[0] = 1;
            steps[1] = 1;
            for (int i = 2; i <= n; i++) {
                steps[i] = steps[i - 2] + steps[i - 1];
            }
        }

        return steps[n];
    }
}
