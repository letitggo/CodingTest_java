import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] combination;
    static boolean[] selected;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new boolean[n];
        combination = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtrack(0, 0);
        System.out.println(sb);
    }

    private static void backtrack(int depth, int start) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(combination[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (i > 0 && arr[i] == arr[i-1]) continue;
            combination[depth] = arr[i];
            backtrack(depth + 1, i);
        }
    }
}
