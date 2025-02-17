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

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (int i = 2; i * i <= num; i++) { // 제곱근까지 검사
            if (num % i == 0) return false;
        }
        return true;
    }
}
