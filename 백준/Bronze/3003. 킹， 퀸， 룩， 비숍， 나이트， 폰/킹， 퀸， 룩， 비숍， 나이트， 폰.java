import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int[] n = {1, 1, 2, 2, 2, 8};
        int[] answer = new int[n.length];

        for (int i = 0; i <n.length; i++) {
            int target = Integer.parseInt(st.nextToken());
            answer[i] = n[i] - target;
            bw.write(answer[i] + " ");
        }



        bw.close();
    }
}