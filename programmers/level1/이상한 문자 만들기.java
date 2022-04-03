class Solution {
    
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        String[] arr = s.split("");
        for (String value : arr) {
            idx = value.contains(" ") ? 0 : idx + 1;
            answer = answer + (idx % 2 == 0 ? value.toLowerCase() : value.toUpperCase());
        }
        return answer;
    }
    
}
