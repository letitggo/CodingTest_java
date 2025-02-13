import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int max = 0;
        int c = 1, d = 1;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int isMax = Integer.parseInt(st.nextToken());
                if (isMax > max) {
                    max = isMax;
                    c = i;
                    d = j;
                }
            }
        }

        System.out.print(max + "\n" + c + " " + d);

        br.close();
        bw.close();

    }
}