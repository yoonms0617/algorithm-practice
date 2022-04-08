import java.util.Arrays;

class Solution {
  
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        Arrays.sort(arr);
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                size++;
            }
        }
        if (size == 0) {
            return new int[]{-1};
        }
        answer = new int[size];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index++] = arr[i];
            }
        }
        return answer;
    }
  
}
