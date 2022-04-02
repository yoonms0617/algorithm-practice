import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    private int getK(int[] array, int start, int end, int idx) {
        List<Integer> list = new ArrayList<>();
        for (int i = start - 1; i < end; i++) {
            list.add(array[i]);
        }
        Collections.sort(list);
        return list.get(idx - 1);
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = getK(array, commands[i][0], commands[i][1], commands[i][2]);
        }
        return answer;
    }
    
}
