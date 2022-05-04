import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
  
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        int[] answer = new int[size];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idIdxMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(id_list[i], new HashSet<>());
            idIdxMap.put(id_list[i], i);
        }
        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }
        for (String s : id_list) {
            HashSet<String> send = map.get(s);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idIdxMap.get(name)] = answer[idIdxMap.get(name)] + 1;
                }
            }
        }
        return answer;
    }
  
}
