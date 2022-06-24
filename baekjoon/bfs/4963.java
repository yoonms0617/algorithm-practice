import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Point {

    public int x;

    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    private static void countIsland(int[][] map, boolean[][] visited, int x, int y, int h, int w) {
        int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if (newX >= 0 && newY >= 0 && newX < h && newY < w) {
                    if (!visited[newX][newY] && map[newX][newY] == 1) {
                        queue.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        } // end while
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if (w == 0 && h == 0) {
                break;
            }
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            } // draw map
            int result = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        countIsland(map, visited, i, j, h, w);
                        result = result + 1;
                    }
                }
            } // count island
            bw.write(String.valueOf(result));
            bw.newLine();
        } // end while
        bw.flush();
        bw.close();
    }

}
