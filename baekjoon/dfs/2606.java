import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static void dfs(int[][] map, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        int n = map.length - 1;
        stack.push(1);
        visited[1] = true;
        boolean flag;
        while (!stack.isEmpty()) {
            int vt = stack.peek();
            flag = false;
            for (int i = 1; i <= n; i++) {
                if (map[vt][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                stack.pop();
            }
        }
        int count = 0;
        for (boolean value : visited) {
            if (value) {
                count = count + 1;
            }
        }
        System.out.print(count - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        int[][] map = new int[com + 1][com + 1];
        boolean[] visited = new boolean[com + 1];
        for (int i = 0; i < pair; i++) {
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            map[v1][v2] = 1;
            map[v2][v1] = 1;
        }
        dfs(map, visited);
    }

}
