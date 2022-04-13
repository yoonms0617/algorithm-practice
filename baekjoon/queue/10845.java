import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] list = br.readLine().split(" ");
            String cmd = list[0];
            int size = deque.size();
            switch (cmd) {
                case "push":
                    deque.add(Integer.parseInt(list[1]));
                    break;
                case "pop":
                    if (size == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(size + "\n");
                    break;
                case "empty":
                    if (size == 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "front":
                    if (size == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;
                case "back":
                    if (size == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}
