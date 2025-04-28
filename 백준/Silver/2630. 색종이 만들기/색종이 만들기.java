import java.io.*;
import java.lang.annotation.Retention;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void solution(int row, int col, int size) {
        int color = arr[row][col];
        for (int i = row; i < size + row; i++) {
            for (int j = col; j < size + col; j++) {
                if (arr[i][j] != color){
                    solution(row, col, size / 2);
                    solution(row, col + size / 2, size / 2);
                    solution(row + size / 2, col, size / 2);
                    solution(row + size / 2, col + size / 2, size / 2);
                    return;
                }
            }
        }

        if (arr[row][col] == 0) {
            white++;
        } else blue++;
    }
}