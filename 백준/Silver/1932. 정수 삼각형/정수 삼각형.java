import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <i + 1; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = cost[0][0];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i + 1][j] = Math.max(Math.max(dp[i][j] + cost[i + 1][j], dp[i][j] + cost[i + 1][j]), dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j] + cost[i + 1][j + 1], dp[i][j] + cost[i + 1][j + 1]), dp[i+1][j + 1]);
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.println(max);
    }
}