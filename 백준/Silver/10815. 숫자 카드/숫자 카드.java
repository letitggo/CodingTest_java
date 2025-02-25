import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            map.put(target, true);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (map.getOrDefault(target, false)) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }
}
