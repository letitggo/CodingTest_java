import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int ans = 0;

        for (String num : st.nextToken().split("\\+")) {
            ans += Integer.parseInt(num);
        }

        while (st.hasMoreTokens()) {
            for (String num : st.nextToken().split("\\+")) {
                ans -= Integer.parseInt(num);
            }
        }

        System.out.println(ans);
    }
}