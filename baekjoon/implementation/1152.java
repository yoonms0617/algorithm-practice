import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.length() == 1) {
            if (str.equals(" ")) {
                System.out.print(0);
                return;
            }
        }
        String input= str.trim();
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 32) {
                cnt = cnt + 1;
            }
        }
        System.out.print(cnt + 1);
    }

}
