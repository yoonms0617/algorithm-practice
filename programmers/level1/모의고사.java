class Solution {
  
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[][] guess = {{1, 2, 3, 4, 5}, 
                         {2, 1, 2, 3, 2, 4, 2, 5}, 
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int length = answers.length;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < length; j++) {
                if (answers[j] == guess[i][j % guess[i].length]) {
                    scores[i]++;
                }
            }
        }
        int maxScore = 0;
        for (int i = 0; i < 3; i++) {
            maxScore = Math.max(maxScore, scores[i]);
        }
        if (maxScore == 0) {
            return new int[]{1, 2, 3};
        }
        int size = 0;
        for (int i = 0; i < 3; i++) {
            if (maxScore == scores[i]) {
                size = size + 1;
            }
        }
        int[] answer = new int[size];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                answer[index++] = i + 1;
            }
        }
        return answer;
    }
  
}
