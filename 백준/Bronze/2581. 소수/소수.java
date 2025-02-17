import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean isFind = false;
        int min = 0;
        int sum = 0;

        for (int i = N; i <= M ; i++) {
            if (isPrime(i)) {
                if (!isFind){
                    isFind = true;
                    min = i;
                }
                sum += i;
            }
        }
        if (isFind)
            System.out.print(sum + "\n" + min);
        else
            System.out.println(-1);

        bw.close();
        br.close();
    }

    private static boolean isPrime(int n) {
        int cnt = 0;
        for (int j = 1; j <= n/2; j++) {
            if (n % j == 0) {
                cnt++;
            }
        }
        cnt++;
        if (cnt == 2){
            return true;
        }
        return false;
    }
}
