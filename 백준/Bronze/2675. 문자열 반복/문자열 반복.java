import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder p = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                p.append(String.valueOf(str.charAt(j)).repeat(repeat));
            }

            bw.write(p + "\n");
        }

        br.close();
        bw.close();
    }
}
