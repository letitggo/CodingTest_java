import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dp(arr, n);
        System.out.println(answer);
    }

    private static int dp(int[] arr, int n) {
        if (n == 1) return arr[1];

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[2] + dp[1];
        
        for (int i = 3; i < n + 1; i++) {
            int val1 = dp[i - 2] + arr[i];
            int val2 = arr[i - 1] + dp[i - 3] + arr[i];
            dp[i] = Math.max(Math.max(val1, val2), dp[i-1]);
        }
        return dp[n];
    }
}