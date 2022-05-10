import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    private static final int MAX = 10_001;

    public static int d(int number) {
        int sum = number;
        while (number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] notSelfNumber = new boolean[MAX];
        for (int i = 1; i < MAX; i++) {
            int n = d(i);
            if (n < MAX) {
                notSelfNumber[n] = true;
            }
        }
        for (int i = 1; i < MAX; i++) {
            if (!notSelfNumber[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

}
