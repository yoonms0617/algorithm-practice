class Solution {
  
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        int min = 987654321;
        int max = -987654321;
        for (int i = 0; i < list.length; i++) {
            int numA = Integer.parseInt(list[i]);
            int numB = Integer.parseInt(list[i]);
            min = Math.min(min, numA);
            max = Math.max(max, numB);
        }
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
  
}
