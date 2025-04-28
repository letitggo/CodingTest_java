import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] ans = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }

    private static void divide(int row, int col, int size) {

        int initial = arr[row][col];
        boolean flag = true;

        outer:
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (initial != arr[i][j]){
                    flag = false;
                    break outer;
                }
            }
        }

        // 모두 같은 값이면
        if (!flag) {
            int nextSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(
                        row + i * nextSize, 
                        col + j * nextSize, 
                        nextSize
                    );
                }
            }
            return;
        }

        ans[initial + 1]++;
    }
}