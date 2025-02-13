import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] answer = new int[c][d];

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < d; j++) {
                answer[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < d; j++) {
                answer[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
        bw.close();

    }
}