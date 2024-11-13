import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            total += s.charAt(i) - '0';
        }

        bw.write(total + "\n");

        br.close();
        bw.close();
    }
}
