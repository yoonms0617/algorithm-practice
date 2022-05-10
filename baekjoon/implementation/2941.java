import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int solution(String str) {
        int answer = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == 'c') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == '=') {
                        i = i + 1;
                    } else if (str.charAt(i + 1) == '-') {
                        i = i + 1;
                    }
                }
            } else if (c == 'd') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == 'z') {
                        if (i < length - 2) {
                            if (str.charAt(i + 2) == '=') {
                                i = i + 2;
                            }
                        }
                    } else if (str.charAt(i + 1) == '-') {
                        i = i + 1;
                    }
                }
            } else if (c == 'l') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == 'j') {
                        i = i + 1;
                    }
                }
            } else if (c == 'n') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == 'j') {
                        i = i + 1;
                    }
                }
            } else if (c == 's') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == '=') {
                        i = i + 1;
                    }
                }
            } else if (c == 'z') {
                if (i < length - 1) {
                    if (str.charAt(i + 1) == '=') {
                        i = i + 1;
                    }
                }
            }
            answer = answer + 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = solution(str);
        System.out.print(answer);
    }

}
