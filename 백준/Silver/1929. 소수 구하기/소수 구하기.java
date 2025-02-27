import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i * i <= num; i++) { // 제곱근까지 검사
            if (num % i == 0) return false;
        }
        return true;
    }
}
