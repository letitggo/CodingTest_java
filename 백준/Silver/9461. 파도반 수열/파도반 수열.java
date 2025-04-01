import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[] arr = init();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n-1]).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }


    private static long[] init() {
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        for (int i = 5; i < 100; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
        return arr;
    }
}
