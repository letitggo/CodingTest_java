import java.util.Scanner;

public class Main {
    static int N, K;
    static String[] numbers;
    static int[] sMod;
    static int[] pow10;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        numbers = new String[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLine().trim();
        }
        K = sc.nextInt();

        if (K == 1) {
            System.out.println("1/1");
            return;
        }

        sMod = new int[N];
        pow10 = new int[N];
        for (int i = 0; i < N; i++) {
            String s = numbers[i];
            int mod = 0;
            for (char c : s.toCharArray()) {
                mod = (mod * 10 + (c - '0')) % K;
            }
            sMod[i] = mod;

            int pow = 1;
            for (int j = 0; j < s.length(); j++) {
                pow = (pow * 10) % K;
            }
            pow10[i] = pow;
        }

        dp = new long[1 << N][K];
        dp[0][0] = 1;

        for (int state = 0; state < (1 << N); state++) {
            for (int rem = 0; rem < K; rem++) {
                if (dp[state][rem] == 0) continue;
                for (int i = 0; i < N; i++) {
                    if ((state & (1 << i)) == 0) {
                        int newState = state | (1 << i);
                        int newRem = (rem * pow10[i] + sMod[i]) % K;
                        dp[newState][newRem] += dp[state][rem];
                    }
                }
            }
        }

        long total = 1;
        for (int i = 2; i <= N; i++) {
            total *= i;
        }
        long count = dp[(1 << N) - 1][0];

        if (count == 0) {
            System.out.println("0/1");
            return;
        }

        long gcd = gcd(count, total);
        System.out.println((count / gcd) + "/" + (total / gcd));
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}