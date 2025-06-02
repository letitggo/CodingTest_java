import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        bfs();
    }

    private static void bfs() {
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            visited[p[1]][p[0]] = true;

            for (int i = 0; i < 4; i++) {
                int targetX = p[0] + dx[i];
                int targetY = p[1] + dy[i];
                if (isValid(targetX, targetY) && arr[targetY][targetX] == 1 && !visited[targetY][targetX]) {
                    visited[targetY][targetX] = true;
                    queue.offer(new int[]{targetX, targetY, p[2] + 1});
                }
            }
            if (p[0] == m - 1 && p[1] == n - 1) {
                System.out.println(p[2] + 1);
                return;
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
