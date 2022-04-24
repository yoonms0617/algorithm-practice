import java.util.HashMap;
import java.util.Map;

class Solution {
    
    private Map<String, Integer> initMap() {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(arr[i], i);
        }
        return map;
    }

    private boolean isNumber(char c) {
        return c > 47 && c < 58;
    }
    
    public int solution(String s) {
        Map<String, Integer> map = initMap();
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNumber(c)) {
                answer.append(c);
            } else {
                temp.append(c);
                String key = temp.toString();
                if (map.containsKey(key)) {
                    int value = map.get(key);
                    answer.append(value);
                    temp.setLength(0);
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
    
    
    
}
