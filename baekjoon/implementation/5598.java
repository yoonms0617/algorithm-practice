import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder encoded = new StringBuilder();
        String plain = br.readLine();
        int length = plain.length();
        for (int i = 0; i < length; i++) {
            char c = plain.charAt(i);
            c = (char) (c - 3);
            if (c < 65) {
                c = (char) (c + 26);
            }
            encoded.append(c);
        }
        System.out.print(encoded.toString());
    }

}
