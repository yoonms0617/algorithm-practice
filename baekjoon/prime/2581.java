import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int max = 10_001;
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
        int sum = 0;
        int min = 987654321;
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sum = sum + i;
                if (i < min) {
                    min = i;
                }
            }
        }
        if (sum == 0) {
            System.out.print(-1);
            return;
        }
        System.out.println(sum);
        System.out.print(min);
    }

}
