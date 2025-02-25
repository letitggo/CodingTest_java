import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Boolean> strMap = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            strMap.put(br.readLine(), true);
        }

        for (int i = 0; i < m; i++) {
            if (strMap.getOrDefault(br.readLine(), false)) {
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
        bw.close();
    }
}
