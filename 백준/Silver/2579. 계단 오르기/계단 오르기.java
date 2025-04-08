import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = 0;
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        if (n > 1) {
            dp[0] = arr[0];
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(
                        dp[i - 3] + arr[i - 1] + arr[i],
                        dp[i - 2] + arr[i]
                );
            }
            System.out.println(dp[n]);
        }else {
            System.out.println(arr[1]);
        }

    }
}