import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for(int j = n-i-1; j > 0; j--){
                bw.write(" ");
            }
            for(int j = 0; j < i*2+1; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        // 아랫별
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < i+1; j++) {
                bw.write(" ");
            }
            // n * 2 = 10
            for (int j = n*2-3-i*2; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}