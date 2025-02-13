import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (true) {
            if(N < B)
                break;

            int remain = (char) (N % B);
            if (B > 10 && remain >= 10) {
                char ch = (char) (remain + 'A' - 10);
                sb.insert(0, ch);
            }else{
                sb.insert(0, remain);
            }
            N = N / B;

        }
        if (B > 10 && N >= 10) {
            char ch = (char) (N + 'A' - 10);
            sb.insert(0, ch);
        }else{
            sb.insert(0, N);
        }
        System.out.println(sb);

    }
}