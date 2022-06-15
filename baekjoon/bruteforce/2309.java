import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        boolean[] check = new boolean[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total = total + arr[i];
        }
        Arrays.sort(arr);
        Arrays.fill(check, true);
        int less = total - 100;
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[j] == arr[i]) {
                    continue;
                }
                sum = arr[i] + arr[j];
                if (sum == less) {
                    check[i] = false;
                    check[j] = false;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (check[i]) {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

}
