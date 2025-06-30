import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] df = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    visited[i][j] = true;
                }
                arr[i][j] = num;
            }
        }

        bfs();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }

    static private void bfs() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    fill(i, j, 0);
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            cnt = u[2];

            fill(u[0], u[1], u[2]);
        }
    }

    static private void fill(int n, int m, int cnt){
        for (int k = 0; k < df.length; k++) {
            if (n + df[k][0] >= 0 && n + df[k][0] < N && m + df[k][1] >= 0 && m + df[k][1] < M) {
                if (arr[n + df[k][0]][m + df[k][1]] == 0) {
                    int[] d = {n + df[k][0], m + df[k][1], cnt + 1};
                    queue.offer(d);
                    arr[d[0]][d[1]] = 1;
                }
            }
        }
    }
}








