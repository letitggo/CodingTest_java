import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] unbVisited; 
    static boolean[][] bVisited;   

    static Queue<int[]> queue = new LinkedList<>();
    static int[][] df = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 이동 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        unbVisited = new boolean[N][M];
        bVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = row[j] - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        if (N == 1 && M == 1) return 1; // 시작=종료

        // r, c, 벽부순여부, 이동횟수
        queue.offer(new int[]{0, 0, 0, 1});
        unbVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], broken = cur[2], cnt = cur[3];

            if (r == N-1 && c == M-1) return cnt;

            for (int i = 0; i < 4; i++) {
                int nr = r + df[i][0];
                int nc = c + df[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                // 1. 이동 가능한 칸(0)인 경우
                if (arr[nr][nc] == 0) {
                    if (broken == 0 && !unbVisited[nr][nc]) {
                        unbVisited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, 0, cnt+1});
                    } else if (broken == 1 && !bVisited[nr][nc]) {
                        bVisited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, 1, cnt+1});
                    }
                }
                // 2. 벽(1)인 경우 + 아직 벽 안 부순 상태
                else if (broken == 0 && !bVisited[nr][nc]) {
                    bVisited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, 1, cnt+1});
                }
            }
        }
        return -1;
    }
}
