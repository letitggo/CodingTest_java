import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int target = 3;
        int cnt = 1;
        while (true) {
            if (n - target <= 0)
                break;
            n = n - target;
            target+=2;
            cnt++;
        }


        System.out.println(cnt);

        
        br.close();
        bw.close();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
