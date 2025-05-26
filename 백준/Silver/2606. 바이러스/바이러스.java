import java.io.*;
import java.util.*;

public class Main {
    static int u;   // 정점
    static int v;   // 간선
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        u = Integer.parseInt(br.readLine());
        v = Integer.parseInt(br.readLine());
        visited = new boolean[u + 1];

        for (int i = 0; i < u + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int e : graph.get(u)) {
                if (!visited[e]) {
                    visited[e] = true;
                    answer++;
                    queue.offer(e);
                }
            }
        }
    }
}
