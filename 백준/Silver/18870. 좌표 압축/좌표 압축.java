import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];

        Set<Integer> xSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            x[i] = value;
        }

        int[] sortedX = Arrays.stream(x).distinct().sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i : sortedX) {
            map.put(i, rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : x) {
            sb.append(map.get(i) + " ");
        }

        System.out.println(sb);

        br.close();
        bw.close();
    }

}
