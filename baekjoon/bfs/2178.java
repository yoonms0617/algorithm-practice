import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    private static void bfs(int[][] maze, boolean[][] visited, int n, int m) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now.getX() + dx[i];
                int newY = now.getY() + dy[i];
                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    if (maze[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.add(new Point(newX, newY));
                        visited[newX][newY]= true;
                        maze[newX][newY] = maze[now.getX()][now.getY()] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }
        bfs(maze, visited, n, m);
        System.out.print(maze[n - 1][m - 1]);
    }

}
