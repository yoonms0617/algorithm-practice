class Solution {
    
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        boolean[] check = new boolean[201];
        int value = 0;
        int size = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                value = numbers[i] + numbers[j];
                if (check[value]) {
                    continue;
                }
                check[value] = true;
                size = size + 1;
            }
        }
        int idx = 0;
        int[] answer = new int[size];
        for (int i = 0; i < 201; i++) {
            if (check[i]) {
                answer[idx] = i;
                idx = idx + 1;
            }
        }
        return answer;
    }
    
}
