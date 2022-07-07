import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    public static void dfs(int v, ArrayList<ArrayList<Integer>> lists, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        sb.append(v).append(" ");
        boolean flag = true;
        while (!stack.isEmpty()) {
            int vt = stack.peek();
            flag = false;
            for (int a : lists.get(vt)) {
                if (!visited[a]) {
                    stack.push(a);
                    visited[a] = true;
                    flag = true;
                    sb.append(a).append(" ");
                    break;
                }
            }
            if (!flag) {
                stack.pop();
            }
        }
    }

    public static void bfs(int v, ArrayList<ArrayList<Integer>> lists, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v).append(" ");
            for (int a : lists.get(v)) {
                if (!visited[a]) {
                    queue.add(a);
                    visited[a] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] list = br.readLine().split(" ");
        int n = Integer.parseInt(list[0]);
        int m = Integer.parseInt(list[1]);
        int v = Integer.parseInt(list[2]);
        boolean[] visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            list = br.readLine().split(" ");
            int v1 = Integer.parseInt(list[0]);
            int v2 = Integer.parseInt(list[1]);
            lists.get(v1).add(v2);
            lists.get(v2).add(v1);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(lists.get(i));
        }
        dfs(v, lists, visited);
        bw.write(sb.toString());
        bw.newLine();
        sb.setLength(0);
        Arrays.fill(visited, false);
        bfs(v, lists, visited);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}
