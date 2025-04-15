import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[501];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[index] = value;
        }
        dp = new int[501];

        int answer = dp(arr);
        System.out.println(n - answer);
    }

    private static int dp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

}