import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int recursiveCount = 0;
    static int dynamicCount = 0;
    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        f = new int[n];
        recursive(n);
        dynamic(n);
        System.out.print(recursiveCount + " " + (dynamicCount + 1));
    }

    private static int recursive(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++;
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    private static int[] dynamic(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            dynamicCount++;
        }
        return f;
    }
}
