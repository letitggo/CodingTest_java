import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] s;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0);
        System.out.println(minDiff);
    }

    private static void backtrack(int idx, int count) {
        if (count == n / 2) {
            calculateDifference();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, count + 1);
                visited[i] = false;
                if (minDiff == 0) return; // 조기 종료
            }
        }
    }

    private static void calculateDifference() {
        int start = 0, link = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += s[i][j] + s[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += s[i][j] + s[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}
