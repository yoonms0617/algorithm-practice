import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int calcGCD(int a, int b) {
        int tmp = 0;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static int calcLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");
        int a = Integer.parseInt(list[0]);
        int b = Integer.parseInt(list[1]);
        int gcd = calcGCD(a, b);
        int lcm = calcLCM(a, b, gcd);
        System.out.println(gcd);
        System.out.print(lcm);
    }

}
