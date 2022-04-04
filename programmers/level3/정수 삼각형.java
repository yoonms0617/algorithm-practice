class Solution {
  
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = 0;
        int height = triangle.length;
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < height; i++) {
            length = triangle[i].length;
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    dp[i][0] = triangle[i][j] + dp[i - 1][j];
                } else if (j == length - 1) {
                    dp[i][length - 1] = triangle[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
  
}
