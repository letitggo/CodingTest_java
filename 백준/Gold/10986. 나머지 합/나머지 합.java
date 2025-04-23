import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] sum = new long[n + 1];
        int[] remain = new int[m];
        remain[0] = 1; // sum[0] = 0 이므로, sum[0] % m = 0. 나머지 0의 개수를 1로 시작

        long answer = 0L; // 결과를 저장할 변수를 long 타입으로 선언

        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            int targetRemainder = (int) (sum[i] % m); // 현재 누적합의 나머지 계산

            answer += remain[targetRemainder];
            remain[targetRemainder]++;
        }
        
        System.out.println(answer);
    }
}