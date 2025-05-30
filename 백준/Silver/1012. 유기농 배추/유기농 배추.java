import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int m;
    static int n;
    static int k;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dxy = {{0, -1}, {0, +1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            int cnt = 0;
            for (int c = 0; c < n; c++) {
                for (int r = 0; r < m; r++) {
                    if (arr[c][r] == 1 && !visited[c][r]) {
                        bfs(c, r);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int col, int row) {
        visited[col][row] = true;
        int[] uv = {col, row};
        queue.offer(uv);

        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            for (int i = 0; i < dxy.length; i++) {
                int targetY = u[0] + dxy[i][0];
                int targetX = u[1] + dxy[i][1];
                if ((targetX >= 0 && targetY >= 0) && targetX < m && targetY < n && arr[targetY][targetX] == 1 ) {
                    if (!visited[targetY][targetX]) {
                        visited[targetY][targetX] = true;
                        int[] v = {targetY, targetX};
                        queue.add(v);
                    }
                }
            }
        }
    }

}
