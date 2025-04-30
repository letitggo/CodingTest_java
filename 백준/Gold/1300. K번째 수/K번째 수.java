import java.io.*;

public class Main {
    static int n;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(search());
    }

    static long search() {
        long low = 1;
        long high = (long) n * n;
        long ans = 1;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (check(mid) < k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    static long check(long mid) {
        long cnt = 0;

        for (int i = 1; i < n + 1; i++) {
            cnt += Math.min(mid / i, n);
        }
        return cnt;
    }
}
