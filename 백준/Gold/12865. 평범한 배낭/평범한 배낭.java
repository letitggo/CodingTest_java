import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 물품의 수
        int k = Integer.parseInt(st.nextToken());   // 버틸 수 있는 무게

        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            v[i] = value;   // 무게
            w[i] = weight;   // 가치
        }

        // 물건 i
        for (int i = 1; i < n + 1; i++) {
            // j = 무게
            for (int j = 1; j < k + 1; j++) {
                if (w[i] <= j) {    // 물건을 넣을 수 있으면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {    // 넣을 수 없으면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][k]);

        br.close();
        bw.close();
    }
}