class Solution {
  
    public String solution(int a, int b) {
        int[]    month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day   = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int totalDay = 0;
        for (int i = 1; i < a; i++) {
            totalDay = totalDay + month[i - 1];
        }
        totalDay = totalDay + b - 1;
        return day[(totalDay + 5) % 7];
    }
  
}
