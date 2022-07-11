import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
    
}

public class Main {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static int bfs(int[][] board, boolean[][] visited, int x, int y, int n) {
        Queue<Point> queue = new LinkedList<>();
        int count = 1;
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point curPt = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPt.x() + dx[i];
                int ny = curPt.y() + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int res = bfs(board, visited, i, j, n);
                    list.add(res);
                    count = count + 1;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        Collections.sort(list);
        for (int value : list) {
            bw.write(String.valueOf(value));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
