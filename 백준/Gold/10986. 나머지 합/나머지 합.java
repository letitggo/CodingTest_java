import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] sum = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int[] remain = new int[m];
        for (int i = 1; i < n + 1; i++) {
            int target = (int) (sum[i] % m);
            remain[target]++;
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            if (remain[i] > 1) {
                answer += (long) remain[i] * (remain[i] - 1) / 2;
            }
        }

        System.out.println(answer + remain[0]);

        bw.flush();
    }
}