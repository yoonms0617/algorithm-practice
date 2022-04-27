import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> answer = new Stack<>();
        Stack<Character> temp = new Stack<>();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            temp.push(c);
        }
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] list = br.readLine().split(" ");
            String cmd = list[0];
            switch (cmd) {
                case "L":
                    if (temp.isEmpty()) {
                        continue;
                    }
                    answer.push(temp.pop());
                    break;
                case "D":
                    if (answer.isEmpty()) {
                        continue;
                    }
                    temp.push(answer.pop());
                    break;
                case "B":
                    if (temp.isEmpty()) {
                        continue;
                    }
                    temp.pop();
                    break;
                case "P":
                    char value = list[1].charAt(0);
                    temp.push(value);
                    break;
            }
        }
        if (!temp.isEmpty()) {
            while (!temp.isEmpty()) {
                answer.push(temp.pop());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!answer.isEmpty()) {
            result.append(answer.pop());
        }
        System.out.print(result);
    }

}
