import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > max) max = value;
            arr[i] = value;
        }
        dp = new int[max + 1];

        int answer = dp(arr, n);
        System.out.println(answer);
    }

    private static int dp(int[] arr, int n) {
        dp[arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            dp[arr[i]] = 1;
                for (int j = i; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                    dp[arr[i]] = Math.max(dp[arr[j]] + 1, dp[arr[i]]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

}