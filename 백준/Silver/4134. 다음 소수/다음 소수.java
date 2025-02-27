import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < n; i++) {
            long target = Long.parseLong(br.readLine());
            while (true) {
                if (!isPrime(target)) {
                    target++;
                }else{
                    break;
                }
            }
            sb.append(target).append("\n");
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        for (long i = 2; i * i <= num; i++) { // 제곱근까지 검사
            if (num % i == 0) return false;
        }
        return true;
    }
}
