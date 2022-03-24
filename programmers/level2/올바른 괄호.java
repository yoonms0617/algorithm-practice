class Solution {
  
    boolean solution(String s) {
        boolean answer = false;
        int length = s.length();
        if (s.charAt(length - 1) == '(' || s.charAt(0) == ')') {
            return false;
        }
        int open = 0;
        int close = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open = open + 1;
            } else {
                close = close + 1;
            }
            if (open < close) {
                return false;
            }
        }
        if (open == close) {
            answer = true;
        }
        return answer;
    }
  
}
