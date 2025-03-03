import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k - 1; j++) {
                list.addLast(list.removeFirst());
            }
            sb.append(list.removeFirst()).append(", ");

        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.println(sb);

        // 1 2 4 5 6 7
        // 3 6 2 5
        br.close();
        bw.close();
    }
}
