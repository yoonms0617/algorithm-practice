import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            char c = arr[i];
            int index = i;
            if (c == '<') {
                sb.append(c);
                index = i + 1;
                while (arr[index] != '>') {
                    sb.append(arr[index]);
                    index = index + 1;
                }
                sb.append('>');
                i = index;
            } else {
                while (true) {
                    if (arr[index] == '<') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        break;
                    }
                    if (arr[index] == ' ') {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(" ");
                        index = index + 1;
                    }
                    stack.push(arr[index]);
                    index = index + 1;
                    if (size == index) {
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        break;
                    }
                }
                i = index - 1;
            }
        }
        System.out.print(sb);
    }

}
