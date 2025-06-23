import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int curX;
    static int curY;
    static int targetX;
    static int targetY;
    static int n;
    static boolean[][] visited;
    static Queue<int[]> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());    // 한 변의 길이
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());
            visited[curX][curY] = true;

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            int bfs = bfs();
            sb.append(bfs).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        offerQ(curX, curY, 0);
        int min = Integer.MAX_VALUE;
        while (!graph.isEmpty()) {
            int[] o = graph.poll();

            if (targetX == o[0] && targetY == o[1]){
                min = Math.min(min, o[2]);
            }

            offerQ(o[0], o[1], o[2]);
        }

        if (min == Integer.MAX_VALUE){
            return 0;
        }

        return min;
    }

    private static void offerQ(int x, int y, int cnt){
        int[][] o = {
                {x - 1, y - 2}, {x - 1, y + 2},
                {x - 2, y - 1}, {x - 2, y + 1},
                {x + 1, y - 2}, {x + 1, y + 2},
                {x + 2, y - 1}, {x + 2, y + 1}
        };

        for (int i = 0; i < o.length; i++) {
            if (o[i][0] >= 0 && o[i][0] < n && o[i][1] >= 0 && o[i][1] < n){
                int[] df = {o[i][0], o[i][1], cnt + 1};
                if (!visited[df[0]][df[1]]) {
                    visited[df[0]][df[1]] = true;
                    graph.offer(df);
                }
            }
        }
    }
}