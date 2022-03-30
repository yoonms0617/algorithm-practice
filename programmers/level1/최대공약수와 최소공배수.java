class Solution {
    
    private int gcd(int a, int b) {
        int temp = 0;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        return answer;
    }
    
}
