import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[][] matrix = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = st.nextToken();
            matrix[i][1] = st.nextToken();
        }

        Arrays.sort(matrix, (s1, s2) -> {
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][0] + " ");
            System.out.println(matrix[i][1]);
        }

        br.close();
        bw.close();
    }

}
