class Solution {
    
    public double solution(int[] arr) {
        double answer = 0;
        int size = arr.length;
        for (int num : arr) {
            answer = answer + num;
        }
        return answer / size;
    }
    
}
