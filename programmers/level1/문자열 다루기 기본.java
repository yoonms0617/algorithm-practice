class Solution {
  
    public boolean solution(String s) {
        boolean answer = true;
        int length = s.length();
        if (length == 4 || length == 6) {
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c >= 97 && c <= 122) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
  
}
