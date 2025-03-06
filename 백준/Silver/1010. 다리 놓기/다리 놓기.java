import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m, n));
        }

        br.close();
        bw.close();
    }

    public static int combination(int n, int r) {
        if (r == 1) {
            return n;
        }
        if (n == 0) {
            return 1;
        }
        return n * combination(n - 1, r - 1) / r;
    }
}
