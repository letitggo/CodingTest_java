import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = gcd(arr[1] - arr[0], arr[2] - arr[1]);
        for (int i = 1; i < n-1; i++) {
            gcd = gcd(Math.min(gcd, arr[i + 1] - arr[i]), Math.max(gcd, arr[i + 1] - arr[i]));
        }

        int answer = 0;

        for (int i = 0; i < n-1; i++) {
            int value = arr[i + 1] - arr[i];
            if (value != gcd) {
                answer += (value / gcd) - 1;
            }
        }
        System.out.println(answer);

        br.close();
        bw.close();
    }

    // 최대공약수 구하기
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
