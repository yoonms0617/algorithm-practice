import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static void dfs(int y, int x, int m, int n, int[][] farm, boolean[][] visited) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && nx < m && ny < n) {
                if (farm[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx, m, n, farm, visited);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            int[][] farm = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                farm[y][x] = 1;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, m, n, farm, visited);
                        count = count + 1;
                    }
                }
            }
            System.out.println(count);
        }
    }

}
