class Solution {
  
    public int solution(int n) {
        int answer = 0;
        int[] primes = new int[n + 1];
        primes[0] = 1;
        primes[1] = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                continue;
            }
            for (int j = i + i; j <= n; j = j + i) {
                primes[j] = 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                answer = answer + 1;
            }
        }
        return answer;
    }
  
}
