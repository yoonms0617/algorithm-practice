class Solution {
    
    private boolean isP(char c) {
        return c == 80 || c == 112;
    }

    private boolean isY(char c) {
        return c == 89 || c == 121;
    }

    boolean solution(String s) {
        boolean answer = true;
        int countP = 0;
        int countY = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isP(c)) {
                countP++;
            } else if (isY(c)) {
                countY++;
            }
        }
        if (countP != countY) {
            answer = false;
        }
        return answer;
    }
}
