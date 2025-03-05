import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] structureArr = new int[n];
        ArrayDeque<Integer> queueStack = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            structureArr[i] = value;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (structureArr[i] == 0) {
                queueStack.offerLast(value);
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            queueStack.offerFirst(value);
            sb.append(queueStack.pollLast()).append(" ");
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }
}
