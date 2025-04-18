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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        arr[1] = Integer.parseInt(st.nextToken());
        
        // 누적합 계산
        for (int i = 2; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int max = Integer.MIN_VALUE;
        // i번째 누적합에서 i-k 누적합을 뺀다.
        for (int i = k; i < n + 1; i++) {
            max = Math.max(max, arr[i] - arr[i - k]);
        }
        System.out.println(max);

        bw.flush();
        br.close();
        bw.close();
    }
}