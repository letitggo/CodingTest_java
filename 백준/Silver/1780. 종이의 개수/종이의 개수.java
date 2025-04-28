import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int cntOne = 0;
    static int cntZero = 0;
    static int cntMinus = 0;

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

        paper(0, 0, n);
        System.out.println(cntMinus);
        System.out.println(cntZero);
        System.out.println(cntOne);
    }

    private static void paper(int row, int col, int size) {

        int value = arr[row][col];

        for (int i = row; i < size + row; i++) {
            for (int j = col; j < size + col; j++) {
                if (value != arr[i][j]) {
                    int nextSize = size / 3;
                    paper(row, col, nextSize);
                    paper(row, col + nextSize, nextSize);
                    paper(row, col + nextSize * 2, nextSize);

                    paper(row + nextSize, col, nextSize);
                    paper(row + nextSize, col + nextSize, nextSize);
                    paper(row + nextSize, col + nextSize * 2, nextSize);

                    paper(row + nextSize * 2, col, nextSize);
                    paper(row + nextSize * 2, col + nextSize, nextSize);
                    paper(row + nextSize * 2, col + nextSize * 2, nextSize);
                    
                    return;
                }
            }
        }

        if (value == 0) cntZero++;
        if (value == 1) cntOne++;
        if (value == -1) cntMinus++;
    }
}