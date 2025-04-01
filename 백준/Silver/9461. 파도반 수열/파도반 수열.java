import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solution(n)).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }


    private static long solution(int n) {
        if (n > 5) {
            long[] arr = new long[n + 1];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 2;
            arr[4] = 2;

            for (int i = 5; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 5];
            }
            return arr[n - 1];
        } else {
            int[] arr = new int[5];
            arr[0] = 1;
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 2;
            arr[4] = 2;
            return arr[n - 1];
        }
    }
}
