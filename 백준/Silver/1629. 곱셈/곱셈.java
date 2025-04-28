import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long ans = divide(a, b, c);
        System.out.println(ans % c);
    }

    private static long divide(long a, int b, int c) {
        if (b == 0) return 1;
        if (b == 1) return a;
        int share = b / 2;
        int remainder = b % 2;
        long half = divide(a, share, c) % c;
        return (half * half) % c * divide(a, remainder, c) % c;
    }

}