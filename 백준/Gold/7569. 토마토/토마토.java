import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M;
    static int N;
    static int H;
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] df = {
            {0, 0, -1},
            {0, 0, 1},
            {0, -1, 0},
            {0, 1, 0},
            {1, 0, 0},
            {-1, 0, 0},
    };

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1){
                        visited[i][j][k] = true;
                    }
                    arr[i][j][k] = num;
                }
            }
        }

        bfs();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[h][i][j] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static private void bfs() {

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[k][i][j]) {
                        fill(k, i, j, 0);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            cnt = u[3];
            // h, n, m, cnt
            fill(u[0], u[1], u[2], cnt);
        }
    }

    static private void fill(int h, int n, int m, int cnt){
        for (int k = 0; k < df.length; k++) {
            if (n + df[k][1] >= 0 && n + df[k][1] < N && m + df[k][2] >= 0 && m + df[k][2] < M && h + df[k][0] >= 0 && h + df[k][0] < H) {
                if (arr[h + df[k][0]][n + df[k][1]][m + df[k][2]] == 0) {
                    int[] d = {h + df[k][0],n + df[k][1], m + df[k][2], cnt + 1};
                    queue.offer(d);
                    arr[d[0]][d[1]][d[2]] = 1;
                }
            }
        }
    }
}