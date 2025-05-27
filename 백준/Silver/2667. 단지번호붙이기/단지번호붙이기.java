import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>(); // 0왼 1오 2위 3아래
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> answers = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph.add(new ArrayList<>());
                arr[i][j] = c[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    ArrayList<int[]> u = graph.get(i * n + j);
                    if (j > 0 && arr[i][j - 1] == 1) { // 왼
                        int[] temp = {i, j - 1};
                        u.add(temp);
                    }
                    if (j < n - 1 && arr[i][j + 1] == 1) {  // 오
                        int[] temp = {i, j + 1};
                        u.add(temp);
                    }
                    if (i > 0 && arr[i - 1][j] == 1) {  // 위
                        int[] temp = {i - 1, j};
                        u.add(temp);
                    }
                    if (i < n - 1 && arr[i + 1][j] == 1) {    // 아래
                        int[] temp = {i + 1, j};
                        u.add(temp);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        answers.sort(Comparator.naturalOrder());
        answers.forEach(it -> sb.append(it).append("\n"));
        System.out.println(sb);
    }

    private static void bfs(int row, int col) {
        if (visited[row][col]) return;
        arr[row][col] = ++cnt;
        visited[row][col] = true;
        int[] q = {row, col};
        queue.offer(q);
        int answer = 1;

        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            for (int[] e : graph.get(u[0] * n + u[1])) {
                if (!visited[e[0]][e[1]]) {
                    arr[e[0]][e[1]] = cnt;
                    visited[e[0]][e[1]] = true;
                    queue.offer(e);
                    answer++;
                }
            }
        }
        answers.add(answer);
    }
}
