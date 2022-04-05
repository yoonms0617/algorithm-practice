class Solution {
  
    public int solution(String dartResult) {
        int answer = 0;
        int index = 0;
        int[] scores = new int[3];
        String score = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            switch (c) {
                case '*':
                    scores[index - 1] = scores[index - 1] * 2;
                    if (index > 1) {
                        scores[index - 2] = scores[index - 2] * 2;
                    }
                    break;
                case '#':
                    scores[index - 1] = scores[index - 1] * -1;
                    break;
                case 'S':
                    scores[index] = (int) Math.pow(Integer.parseInt(score), 1);
                    index = index + 1;
                    score = "";
                    break;
                case 'D':
                    scores[index] = (int) Math.pow(Integer.parseInt(score), 2);
                    index = index + 1;
                    score = "";
                    break;
                case 'T':
                    scores[index] = (int) Math.pow(Integer.parseInt(score), 3);
                    index = index + 1;
                    score = "";
                    break;
                default:
                    score = score + c;
                    break;
            }
        }
        for (int value : scores) {
            answer = answer + value;
        }
        return answer;
    }
  
}
