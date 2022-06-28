import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int lowerBound(int[] arr, int size, int target) {
        int start = 0;
        int end = size;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upperBound(int[] arr, int size, int target) {
        int start = 0;
        int end = size;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int upper = upperBound(arr, n, num);
            int lower = lowerBound(arr, n, num);
            sb.append(upper - lower).append(" ");
        }

        System.out.print(sb);
    }

}
