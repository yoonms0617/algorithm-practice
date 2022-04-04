class Solution {

    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int loc = 0;
        for (int i = 0; i < seoul.length; i++) {
            String value = seoul[i];
            if (value.equals("Kim")) {
                loc = i;
                break;
            }
        }
        answer = answer + String.valueOf(loc) + "에 있다";
        return answer;
    }
    
}
