import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;
    static final int INCREASE = 0;
    static final int DECREASE = 1;

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
        dp = new int[max + 1][2];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        int answer = dp(arr, n);
        System.out.println(answer);
    }

    private static int dp(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < target){
                    dp[arr[i]][INCREASE] = Math.max(dp[arr[j]][INCREASE] + 1, dp[arr[i]][INCREASE]);
                }
                if (arr[j] > target){
                    dp[arr[i]][DECREASE] = Math.max(Math.max(dp[arr[j]][INCREASE] + 1, dp[arr[j]][DECREASE] + 1), dp[arr[i]][DECREASE]);
                }
            }
        }

        int max = 0;
        for (int[] value : dp) {
            for (int j = 0; j < 2; j++) {
                max = Math.max(max, value[j]);
            }
        }
        return max;
    }
}