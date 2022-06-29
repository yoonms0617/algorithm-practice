import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int temp = 0;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num > temp) {
                for (int i = temp + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                } // end for
                temp = num;
            } else if (stack.peek() != num) {
                System.out.print("NO");
                return;
            } //end if

            stack.pop();
            sb.append("-").append("\n");
        } // end while

        System.out.print(sb);
    }

}
