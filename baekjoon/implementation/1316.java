import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean check(String str) {
        boolean[] check = new boolean[26];
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i + 1);
            if (a != b) {
                if (check[b - 'a']) {
                    return false;
                }
                check[a - 'a'] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        int cnt = 0;
        for (String value : str) {
            if (check(value)) {
                cnt = cnt + 1;
            }
        }
        System.out.print(cnt);
    }

}
