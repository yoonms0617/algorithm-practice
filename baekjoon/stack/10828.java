import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Stack {

    private final String[] arr;
    private int top = 0;
    private int size = 0;

    public Stack(int size) {
        this.arr = new String[size];
    }

    public void push(String number) {
        arr[this.top] = number;
        this.top++;
        this.size++;
    }

    public String pop() {
        if (this.size == 0) {
            return "-1\n";
        }
        String temp = arr[this.top - 1];
        this.top--;
        this.size--;
        return temp + "\n";
    }

    public String top() {
        if (this.size == 0) {
            return "-1\n";
        }
        return arr[this.top - 1] + "\n";
    }

    public String isEmpty() {
        return size == 0 ? "1\n" : "0\n";
    }

    public String getSize() {
        return this.size + "\n";
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line;
        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            switch (line[0]) {
                case "push":
                    stack.push(line[1]);
                    break;
                case "pop":
                    bw.write(stack.pop());
                    break;
                case "top":
                    bw.write(stack.top());
                    break;
                case "size":
                    bw.write(stack.getSize());
                    break;
                case "empty":
                    bw.write(stack.isEmpty());
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

}

