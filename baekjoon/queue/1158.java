import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] list = br.readLine().split(" ");
        int n = Integer.parseInt(list[0]);
        int k = Integer.parseInt(list[1]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int cnt = 0;
        sb.append("<");
        while (queue.size() > 1) {
            int value = queue.poll();
            cnt = cnt + 1;
            if (cnt == k) {
                sb.append(value).append(", ");
                cnt = 0;
                continue;
            }
            queue.add(value);
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb.toString());
    }

}
