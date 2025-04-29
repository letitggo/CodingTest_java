import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int P = 1_000_000_007;
    static final int MAX = 4_000_000;
    static long[] fact = new long[MAX + 1];
    static long[] invFact = new long[MAX + 1];  // 역팩토리얼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        precompute();   // 전처리(팩토리얼, 역팩토리얼 계산)
        System.out.println(comb(n, k));
    }

    static long comb(int n, int k) {
        if (k == 0 || k == n) return 1;
        return fact[n] * invFact[k] % P * invFact[n - k] % P;
    }

    static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % P;
        }

        invFact[MAX] = pow(fact[MAX], P - 2);
        for (int i = MAX - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % P;
        }
    }

    private static long pow(long a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % P;
            }
            a = a * a % P;
            b >>= 1;
        }
        return res;
    }
}