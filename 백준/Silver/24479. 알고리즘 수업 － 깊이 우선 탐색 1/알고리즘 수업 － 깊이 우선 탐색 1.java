import java.io.*;
import java.util.*;

public class Main {
    static int n;   // 정점의 수
    static int m;   // 간선의 수
    static int r;   // 시작 정점
    static boolean[] visited;
    static int[] answer;
    static int depth = 1;
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, ArrayList<Integer>> uv = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        answer = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            uv.put(i, list);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            ArrayList<Integer> fromList = uv.get(from);
            fromList.add(to);
            uv.put(from, fromList);

            ArrayList<Integer> toList = uv.get(to);
            toList.add(from);
            uv.put(to, toList);
        }
        uv.values().forEach(Collections::sort);
        dfs(r, 1);

        for (int i = 1; i < n + 1; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int cur, int depth) {
        ArrayList<Integer> vertex = uv.get(cur);
        visited[cur] = true;
        answer[cur] = depth++;
        for (Integer v : vertex) {
            if (!visited[v]) {
                depth = dfs(v, depth);
            }
        }
        return depth;
    }
}
