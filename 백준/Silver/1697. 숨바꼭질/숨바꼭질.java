import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int answer = Integer.MAX_VALUE;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[Math.max(n, k) + 2];
        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        if (n == k) {
            answer = 0;
            return;
        }
        offerQ(n, 0);

        while (!queue.isEmpty()) {
            int[] v = queue.poll();

            offerQ(v[0], v[1]);

            if (v[0] == k) {
                answer = Math.min(v[1], answer);
            }
        }
    }

    private static void offerQ(int num, int cnt) {
        int[] o1 = {num + 1, cnt + 1};
        int[] o2 = {num - 1, cnt + 1};
        int[] o3 = {num * 2, cnt + 1};
        if (o1[0] <= k + 1 && !visited[o1[0]]) {
            queue.offer(o1);
            visited[o1[0]] = true;
        }
        if (o2[0] >= 0 && !visited[o2[0]]) {
            queue.offer(o2);
            visited[o2[0]] = true;
        }
        if (o3[0] <= k + 1 && !visited[o3[0]]){
            queue.offer(o3);
            visited[o3[0]] = true;
        }
    }
}
