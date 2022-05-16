class Solution {
    
    private static final int MAX = 1_000_000;

    private int countOne(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                cnt = cnt + 1;
            }
            n = n / 2;
        }
        return cnt;
    }

    public int solution(int n) {
        int answer = 0;
        int cntOneByN = countOne(n);
        for (int i = n + 1; i <= MAX; i++) {
            int cntOneByI = countOne(i);
            if (cntOneByN == cntOneByI) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
}
