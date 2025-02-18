import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n == 1) {
                break;
            }
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                    list.add(i);
                    n = n / i;
                    break;
                }
            }
        }

        bw.close();
        br.close();
    }

}
