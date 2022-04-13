import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print(1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int answer = 0;
        while (true) {
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.peek();
                break;
            }
            queue.add(queue.poll());
        }
        System.out.print(answer);
    }

}
