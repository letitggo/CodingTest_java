import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
        backtrack(0, new HashSet<>());
        System.out.println(sb);
    }

    private static void backtrack(int depth, Set<String> set) {

        StringBuilder builder = new StringBuilder();
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                builder.append(combination[i]).append(" ");
            }
            if (!set.contains(builder.toString())){
                set.add(builder.toString());
                sb.append(builder).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            combination[depth] = arr[i];
            selected[i] = true;
            backtrack(depth + 1, set);
            selected[i] = false;
        }
    }
}
