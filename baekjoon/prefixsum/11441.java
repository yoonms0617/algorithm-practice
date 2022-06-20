import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        String[] list = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(list[i - 1]);
        }
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list = br.readLine().split(" ");
            int a = Integer.parseInt(list[0]);
            int b = Integer.parseInt(list[1]);
            int res = arr[b] - arr[a - 1];
            bw.write(String.valueOf(res));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
