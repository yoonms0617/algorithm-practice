import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static String solution(String str) {
        int len = str.length();
        if (str.charAt(0) == ')' || str.charAt(len - 1) == '(') {
            return "NO\n";
        }
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < len; i ++) {
            char c = str.charAt(i);
            if (c == '(') {
                idx++;
            } else {
                idx--;
            }
            if (idx < 0) {
                break;
            }
        }
        if (idx == 0) {
            flag = true;
        }
        return flag ? "YES\n" : "NO\n";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer, str;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            str = br.readLine();
            answer = solution(str);
            bw.write(answer);
        }
        bw.flush();
        bw.close();
    }

}

