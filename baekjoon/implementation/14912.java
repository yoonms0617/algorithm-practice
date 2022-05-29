import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int countNumber(int i, int d) {
        int cnt = 0;
        while (i > 0) {
            if (i % 10 == d) {
                cnt = cnt + 1;
            }
            i = i / 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        int n = Integer.parseInt(list[0]);
        int d = Integer.parseInt(list[1]);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i == d) {
                cnt = cnt + 1;
            } else if (i >= 10) {
                cnt = cnt + countNumber(i, d);
            }
        }
        System.out.print(cnt);
    }

}
