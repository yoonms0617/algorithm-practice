class Solution {
  
    public int[] solution(long n) {
        String value = String.valueOf(n);
        int size = value.length();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = value.charAt((size - i) - 1) - '0';
        }
        return answer;
    }
  
}
