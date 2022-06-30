import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[26];

        String input = br.readLine().toLowerCase();

        if (input.length() == 1) {
            System.out.print(input.toUpperCase());
            return;
        } // end if

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 97;
            count[index] = count[index] + 1;
        } // end for

        int max = 0;
        int maxCnt = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {

            if (count[i] > max) {
                max = count[i];
                index = i;
                maxCnt = 0;
            } // end if

            if (count[i] == max) {
                maxCnt = maxCnt + 1;
            } // end if

        } // end for

        if (maxCnt >= 2) {
            System.out.print("?");
            return;
        } // end if

        System.out.print((char) (index + 'A'));
    }

}
