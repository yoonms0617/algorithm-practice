import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 1_001;
        boolean[] prime = new boolean[max];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!prime[i]) {
                continue;
            }
            for (int j = i * i; j < max; j = j + i) {
                prime[j] = false;
            }
        }
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        String[] list = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(list[i]);
            if (prime[num]) {
                cnt = cnt + 1;
            }
        }
        System.out.print(cnt);
    }

}
