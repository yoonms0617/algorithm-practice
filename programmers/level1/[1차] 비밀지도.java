class Solution {
  
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String value = Integer.toBinaryString(arr1[i] | arr2[i]);
            value = String.format("%" + n + "s", value);
            value = value.replaceAll("1", "#");
            value = value.replaceAll("0", " ");
            answer[i] = value;
        }
        return answer;
    }
  
}
