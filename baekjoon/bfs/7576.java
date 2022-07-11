import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int bfs(int[][] box, Queue<Point> queue, int n, int m) {
        int day = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (box[nx][ny] == 0) {
                        queue.offer(new Point(nx, ny));
                        box[nx][ny] = box[cur.x][cur.y] + 1;
                        day = Math.max(day, box[nx][ny]);
                    }
                }
            }
        }
        return day;
    }

    private static boolean checkBox(int[][] box, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[][] box = new int[n][m];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        int day = bfs(box, queue, n, m);
        if (!checkBox(box, m, n)) {
            System.out.print(-1);
        } else if (day == 0) {
            System.out.print(day);
        } else {
            System.out.print(day - 1);
        }
    }

}
