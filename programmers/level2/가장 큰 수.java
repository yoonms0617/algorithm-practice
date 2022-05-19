import java.util.Arrays;
import java.util.Comparator;

class Solution {
  
    public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] str = new String[size];
        for (int i = 0; i < size; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (str[0].equals("0")) {
            return "0";
        }
        for (String s : str) {
            answer = answer + s;
        }
        return answer;
    }
  
}
