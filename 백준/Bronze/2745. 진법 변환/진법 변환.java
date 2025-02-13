import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int k = 1;

        for (int i = 0; i < N.length(); i++) {
            int c = N.charAt(N.length() - 1 - i) - 'A' + 10;
            if(c < 10){
                c += 7;
            }
            answer += c * k;
            k *= B;
        }

        System.out.println(answer);

        br.close();
        bw.close();

    }
}