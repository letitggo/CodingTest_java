import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 2;
        int k = 1;
        for (int i = 0; i < n; i++) {
            answer = (answer + k);
            k = 2 * k;
        }

        bw.write(answer * answer + "");

        br.close();
        bw.close();

    }
}