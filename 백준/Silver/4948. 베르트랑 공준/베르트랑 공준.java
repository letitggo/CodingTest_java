import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }

    // 좀 더 효율적인 소수 판별
    private static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0) return false; // 짝수 제외

        // 홀수만 3부터 √num까지 검사 (2씩 증가)
        for(int i=3; i*i <= num; i+=2) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
