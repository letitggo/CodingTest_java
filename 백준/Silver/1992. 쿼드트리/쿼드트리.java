import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] arr;
    static int[] ans = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        compression(0, 0, n, sb);
        System.out.println(sb);
    }

    private static void compression(int row, int col, int size, StringBuilder sb) {
        if (size <= 1) {
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    sb.append(arr[i][j]);
                }
            }
            return;
        }

        int initial = arr[row][col];
        boolean canComp = true;
        outer:
        for (int i = row; i < row + size; i++) {
            int j = col;
            for (; j < col + size; j++) {
                if (initial != arr[i][j]) {
                    canComp = false;
                    break outer;
                }
            }
        }

        if (!canComp) {
            int nextSize = size / 2;
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    compression(row + i * nextSize, col + j * nextSize, nextSize, sb);
                }
            }
            sb.append(")");
            return;
        }
        sb.append(arr[row][col]);
    }
}