import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] answers = new int[101];

        int N = 0;
        int M = 0;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            answers[i] = i;
        }

        for (int i = 1; i < M+1; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            for (int j = a; j <= b; j++) {
                int temp = answers[j];
                answers[j] = answers[b];
                answers[b] = temp;
                b--;
            }
        }

        for (int i = 1; i < N+1; i++) {
            bw.write(answers[i] + " ");
        }

        bw.close();
        br.close();
    }
}
