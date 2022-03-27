class Solution {
  
    public int solution(int num) {
        int cnt = 0;
        long collatz = num;
        while (collatz != 1) {
            if (collatz % 2 == 0) {
                collatz = collatz / 2;
            } else {
                collatz = (collatz * 3) + 1;
            }
            cnt++;
            if (cnt >= 500) {
                cnt = -1;
                break;
            }
        }
        return cnt;
    }
  
}
