import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String check(String[] str) {
        int length = str.length;
        int start = 0;
        int end = length - 1;
        for (int i = start; i < length / 2; i++, end--) {
            if (!str[i].equals(str[end])) {
                return "no";
            }
        }
        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            String res = check(input.split(""));
            sb.append(res).append("\n");
        } // end while
        System.out.print(sb);
    }

}
