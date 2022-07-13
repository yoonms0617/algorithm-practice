import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int bit = 0;
        int num;
        while (m-- > 0) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            switch (cmd) {
                case "add":
                    num = Integer.parseInt(input[1]);
                    bit = bit | 1 << (num - 1);
                    break;
                case "remove":
                    num = Integer.parseInt(input[1]);
                    bit = bit & ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(input[1]);
                    bw.write(String.valueOf((bit & 1 << (num - 1)) == 1 << (num - 1) ? 1 : 0));
                    bw.newLine();
                    break;
                case "toggle":
                    num = Integer.parseInt(input[1]);
                    bit = bit ^ 1 << (num - 1);
                    break;
                case "all":
                    bit = ~0;
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}
