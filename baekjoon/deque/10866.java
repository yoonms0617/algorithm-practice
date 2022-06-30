import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

class Deque {

    private int size = 0;

    private int front = 10000;

    private int back = 10000;

    private final int[] array = new int[20001];

    public void pushFront(int x) {
        array[front] = x;
        front--;
        size++;
    }

    public void pushBack(int x) {
        back++;
        size++;
        array[back] = x;
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }
        int pf = array[front + 1];
        front++;
        size--;
        return pf;
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }
        int pb = array[back];
        back--;
        size--;
        return pb;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return array[front + 1];
    }

    public int back() {
        if (isEmpty()) {
            return -1;
        }
        return array[back];
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public int empty() {
        if (isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return this.size;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        java.util.Deque<Integer> das = new ArrayDeque<>();
        Deque deque = new Deque();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {

            String[] input = br.readLine().split(" ");

            String command = input[0];

            if (command.equals("push_front")) {
                int x = Integer.parseInt(input[1]);
                deque.pushFront(x);
            } else if (command.equals("push_back")) {
                int x = Integer.parseInt(input[1]);
                deque.pushBack(x);
            } else if (command.equals("pop_front")) {
                int pf = deque.popFront();
                bw.write(String.valueOf(pf));
                bw.newLine();
            } else if (command.equals("pop_back")) {
                int pb = deque.popBack();
                bw.write(String.valueOf(pb));
                bw.newLine();
            } else if (command.equals("size")) {
                int size = deque.size();
                bw.write(String.valueOf(size));
                bw.newLine();
            } else if (command.equals("empty")) {
                int empty = deque.empty();
                bw.write(String.valueOf(empty));
                bw.newLine();
            } else if (command.equals("front")) {
                int front = deque.front();
                bw.write(String.valueOf(front));
                bw.newLine();
            } else if (command.equals("back")) {
                int back = deque.back();
                bw.write(String.valueOf(back));
                bw.newLine();;
            }

        } // end while

        bw.flush();
        bw.close();
    }

}
