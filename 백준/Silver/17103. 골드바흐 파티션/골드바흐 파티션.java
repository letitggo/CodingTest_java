import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        Set<Integer> primeSet = new HashSet<>();

        for (int i = 0; i < 1000000; i++) {
            if (isPrime(i))
                primeSet.add(i);
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2; j <= n/2; j++) {
                if (primeSet.contains(j) && primeSet.contains(n-j)){
                    cnt++;
                }
//                if (isPrime(j)){
//                    primeSet.add(j);
//                    if (isPrime(n-j)){
//                        primeSet.add(n-j);
//                        cnt++;
//                    }
//                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }

    // 좀 더 효율적인 소수 판별
    private static boolean isPrime(int num) {
//        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        if(num % 2 == 0) return false; // 짝수 제외

        // 홀수만 3부터 √num까지 검사 (2씩 증가)
        for(int i=3; i <= Math.sqrt(num); i+=2) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
