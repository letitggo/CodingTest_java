import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 나무의 수
        m = Integer.parseInt(st.nextToken());   // 상근이가 집으로 가져가려고 하는 나무의 길이
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long ans = search();
        System.out.println(ans);
    }

    static long search() {
        long low = 0;
        long high = arr[n - 1];
        long best = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long temp = compute(mid);
            if (temp >= m) {
                best = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return best;
    }

    private static long compute(long mid) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }
        return sum;
    }
}
