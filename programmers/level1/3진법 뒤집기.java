import java.util.Stack;

class Solution {
    
    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 3);
            n = n / 3;
        }
        int size = stack.size();
        int answer = 0;
        for (int i = 0; i < size; i++) {
            int value = stack.pop();
            int num = (int) (Math.pow(3, i) * value);
            answer = answer + num;
        }
        return answer;
    }
    
}
