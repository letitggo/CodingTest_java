import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(search());
    }

    static int search() {
        int low = 1;
        int high = arr[n - 1];
        int best = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid) >= c) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return best;
    }

    static int check(int len) {
        int pre = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pre >= len) {
                pre = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

}
