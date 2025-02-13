import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] arr = new int[100][100];
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        for(int k = 0; k < n; k++) {

            st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = 99 - Integer.parseInt(st.nextToken());

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (arr[row - i][col + j] != 1) {
                        arr[row - i][col + j] = 1;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
        bw.close();

    }
}