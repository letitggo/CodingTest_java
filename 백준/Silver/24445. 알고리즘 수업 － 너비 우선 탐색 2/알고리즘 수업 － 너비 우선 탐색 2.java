import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] visited;
    static int order = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        graph.forEach(it -> it.sort(Collections.reverseOrder()));

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int node) {
        visited[node] = order++;
        queue.add(node);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int e : graph.get(u)) {
                if (visited[e] == 0) {
                    visited[e] = order++;
                    queue.add(e);
                }
            }
        }
    }
}
