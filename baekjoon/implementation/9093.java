import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    private static String reverse(String[] input) {
        for (String str : input) {
            if (str.length() == 1) {
                STRING_BUILDER.append(str).append(" ");
                continue;
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                STRING_BUILDER.append(str.charAt(i));
            }
            STRING_BUILDER.append(" ");
        }
        STRING_BUILDER.append("\n");
        return STRING_BUILDER.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String input = br.readLine();
            String res = reverse(input.split(" "));
            bw.write(res);
            STRING_BUILDER.setLength(0);
        }
        bw.flush();
        bw.close();
    }

}
