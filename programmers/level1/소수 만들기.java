import java.util.Arrays;

class Solution {
    
    private static final int MAX = 3_001;
    private static final boolean[] PRIME = new boolean[MAX];
    
    private void eratosthenes() {
        Arrays.fill(PRIME, true);
        PRIME[0] = false;
        PRIME[1] = false;
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (!PRIME[i]) {
                continue;
            }
            for (int j = i * i; j < MAX; j = j + i) {
                PRIME[j] = false;
            }
        }
    }
    
    private int dfs(int[] nums, int sum, int start, int depth, int length) {
        int cnt = 0;
        if (depth == 3) {
            if (PRIME[sum]) {
                cnt = cnt + 1;
            }
            return cnt;
        }
        for (int i = start; i < length; i++) {    
            cnt = cnt + dfs(nums, sum + nums[i], i + 1, depth + 1, length);
        }
        return cnt;
    }
    
    public int solution(int[] nums) {
        eratosthenes();
        int length = nums.length;
        return dfs(nums, 0, 0, 0, length);
    }
    
}
