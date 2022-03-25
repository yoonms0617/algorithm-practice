class Solution {
    
    private int calc(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }
        return sum;
    }
    
    public boolean solution(int x) {
        boolean answer = false;
        int temp = calc(x);
        if (x % temp == 0) {
            answer = true;
        }
        return answer;
    }
    
}
