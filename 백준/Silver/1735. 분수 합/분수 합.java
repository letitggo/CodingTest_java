import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int reducedA = (a1 * b2) + (a2 * b1);
        int reducedB = b1 * b2;

        while (true) {
            int gcd = gcd(Math.min(reducedA, reducedB), Math.max(reducedA, reducedB));
            if (gcd == 1)
                break;
            reducedA = reducedA/gcd;
            reducedB = reducedB/gcd;
        }

        System.out.println(reducedA + " " + reducedB);

        br.close();
        bw.close();
    }

    // 최대공약수 구하기
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
