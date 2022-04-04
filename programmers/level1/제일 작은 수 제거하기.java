class Solution {
  
    public int[] solution(int[] arr) {
        int size = arr.length;
        if (size == 1) {
            return new int[]{-1};
        }
        int min = 987654321;
        for (int value : arr) {
            min = Math.min(min, value);
        }
        int idx = 0;
        int[] answer = new int[size - 1];
        for (int value : arr) {
            if (value != min) {
                answer[idx] = value;
                idx++;
            }
        }
        return answer;
    }
  
}
