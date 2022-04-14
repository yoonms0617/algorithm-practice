import java.util.Arrays;
import java.util.Collections;

class Solution {
    
    public long solution(long n) {
        String[] array = ("" + n).split("");
        Arrays.sort(array);
        Collections.reverse(Arrays.asList(array));
        return Long.parseLong(String.join("", array));
    }
    
}
