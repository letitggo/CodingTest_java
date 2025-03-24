import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] sudoku = new int[9][9];
    static int answerCount = 0;
    static int 탐색횟수 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 0) answerCount++;
                sudoku[i][j] = value;
            }
        }
        solution(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solution(int depth, int count) {
        탐색횟수++;
        if (count >= answerCount) {
            return true;
        }
        int k = 0;
        for (int i = depth; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (k >= 10) return false;
                if (sudoku[i][j] == 0) {
                    for (k = 1; k <= 9; k++) {
                        if (can(k, i, j)) {
                            sudoku[i][j] = k;
                            boolean solutioned = solution(depth, count + 1);
                            if (!solutioned) {
                                sudoku[i][j] = 0;
                            }else {
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    private static boolean can(int n, int row, int col) {
        // 3x3 검사
        int targetRow = (row / 3) * 3;
        int targetCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[i + targetRow][j + targetCol] == n) return false;
            }
        }

        // 가로 세로 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == n) return false;
            if (sudoku[i][col] == n) return false;

        }
        return true;
    }
}

/*

5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9


0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0

0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0
 */
