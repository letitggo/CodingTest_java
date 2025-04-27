import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 노드 수
        m = Integer.parseInt(st.nextToken());   // 간선 수
        int start = Integer.parseInt(st.nextToken());   // 탐색 시작 지점
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int ver = Integer.parseInt(st.nextToken());
            graph.get(u).add(ver);
            graph.get(ver).add(u);
        }

        StringBuilder sb = new StringBuilder();
        dfs(start, sb);
        System.out.println(sb);
        Arrays.fill(visited, false);
        bfs(start);
    }

    private static void bfs(int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[start] = true;
            sb.append(node).append(" ");   // 방문 처리
            Collections.sort(graph.get(node));
            ArrayList<Integer> nodes = graph.get(node);
            for (int nodeIdx : nodes) {
                if (!visited[nodeIdx]) {
                    visited[nodeIdx] = true;
                    q.offer(nodeIdx);
                }
            }
        }
        System.out.println(sb);
    }

    private static void dfs(int current, StringBuilder sb) {
        sb.append(current).append(" ");
        visited[current] = true;
        Collections.sort(graph.get(current));

        for (int node : graph.get(current)) {
            if (!visited[node]){
                dfs(node, sb);
            }
        }
    }
}