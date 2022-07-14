import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Board {

    private final Number[] numbers = new Number[26];
    private final boolean[][] check = new boolean[5][5];
    private int count = 0;
    private int countBingo = 0;

    public void setNumber(int number, int x, int y) {
        numbers[number] = new Number(x, y);
    }

    public void checkNumber(int number) {
        Number num = numbers[number];
        check[num.x][num.y] = true;
        count++;
        checkBoard();
    }

    private void checkBoard() {
        checkGaro();
        checkSero();
        checkLeftCross();
        checkRightCross();
        if (countBingo < 3) {
            countBingo = 0;
        }
    }

    private void checkGaro() {
        int count;
        for (int i = 0; i < 5 ;i++) {
            count = 0;
            for (int j = 0; j < 5; j++) {
                if (check[i][j]) {
                    count++;
                }
            }
            countBingo(count);
        }
    }

    private void checkSero() {
        int count;
        for (int i = 0; i < 5 ;i++) {
            count = 0;
            for (int j = 0; j < 5; j++) {
                if (check[j][i]) {
                    count++;
                }
            }
            countBingo(count);
        }
    }

    private void checkLeftCross() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][i]) {
                count++;
            }
        }
        countBingo(count);
    }

    private void checkRightCross() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (check[i][4 - i]) {
                count++;
            }
        }
        countBingo(count);
    }

    private void countBingo(int count) {
        if (count == 5) {
            countBingo++;
        }
    }

    public boolean isThreeBingo() {
        return countBingo >= 3;
    }

    public int count() {
        return count;
    }

    private static class Number {

        public int x;
        public int y;

        public Number(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                board.setNumber(number, i, j);
            }
        }
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                board.checkNumber(number);
                if (board.isThreeBingo()) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.print(board.count());
    }

}
