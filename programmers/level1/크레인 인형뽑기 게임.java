import java.util.Stack;

class Solution {
  
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int move : moves) {
            for (int i = 0; i < size; i++) {
                int number = board[i][move - 1];
                if (number != 0) {
                    if (stack.peek() == number) {
                        stack.pop();
                        answer = answer + 2;
                    } else {
                        stack.push(number);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
  
}
