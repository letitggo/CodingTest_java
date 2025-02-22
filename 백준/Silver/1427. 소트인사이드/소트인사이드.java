import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        long[] arr = new long[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            bw.write(arr[i] + "");
        }

        br.close();
        bw.close();
    }

}
