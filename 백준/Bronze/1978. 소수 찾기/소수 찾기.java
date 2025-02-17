import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            cnt = 0;
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k/2; j++) {
                if (k % j == 0) {
                    cnt++;
                }
            }
            cnt++;
            if (cnt == 2){
                answer++;
            }
        }

        System.out.println(answer);

        bw.close();
        br.close();
    }
}
