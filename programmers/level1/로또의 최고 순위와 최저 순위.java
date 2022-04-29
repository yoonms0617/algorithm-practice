import java.util.Arrays;

class Solution {
    
    private int rank(int num) {
        switch (num) {
            case 0:
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0;
        int cntZero = 0;
        Arrays.sort(win_nums);
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                cntZero = cntZero + 1;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    match = match + 1;
                    break;
                }
            }
        }
        int high = match + cntZero;
        int low = match;
        answer[0] = rank(high);
        answer[1] = rank(low);
        return answer;
    }
    
}
