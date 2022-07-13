import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 3) {
                bw.write(String.valueOf(1));
                bw.newLine();
                continue;
            }
            long[] dp = new long[num + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= num; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
            bw.write(String.valueOf(dp[num]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
