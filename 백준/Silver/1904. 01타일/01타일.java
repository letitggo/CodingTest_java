import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = solution();

        System.out.println(arr[n-1]);
        // 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746로 나눈 나머지 출력
        /*
            n = 1, 1
            n = 2, 00, 11
            n = 3, 3개..?
            n = 4, 0011, 0000, 1001, 1100, 1111
         */

    }

    private static long[] solution() {
        long[] arr = new long[1_000_000];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < 1000000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2])%15746;
        }
        return arr;
    }
}
