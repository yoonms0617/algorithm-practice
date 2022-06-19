import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] list = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(list[i]);
        }
        Arrays.sort(arr);
        n = Integer.parseInt(br.readLine());
        list = br.readLine().split(" ");
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(list[i]);
            int ans = binarySearch(arr, target, start, end);
            sb.append(ans).append(" ");
        }
        System.out.print(sb);
    }

}
