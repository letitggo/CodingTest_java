import java.io.*;

public class Main {

    static boolean[][] chess;
    static int findRow;
    static int answer = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        chess = new boolean[n][n];
        findRow = 0;
        queen(0, n);
        System.out.println(answer);
    }

    private static void queen(int row, int n) {
        // 퀸을 n개 두면 return
        if (count >= n) {
            answer++;
            return;
        }

        for (int i = row; row < n; row++) {
            // 한 row라도 두지 않으면 짜른다.(n개의 퀸을 둬야하기 때문)
            if (findRow < row) return;
            for (int col = 0; col < n; col++) {
                    // 둘 수 있는 자리면
                if (can(row, col, n)) {
                    // 퀸을 둔다.
                    chess[row][col] = true;
                    findRow++;
                    count++;
                    queen(i + 1, n);
                    chess[row][col] = false;
                    findRow--;
                    count--;
                }
            }
        }
    }

    private static boolean can(int row, int col, int n) {
        // 가로축 검사
        for (int i = 0; i < n; i++) {
            if (chess[row][i]) return false;
        }
        // 세로축 검사
        for (int i = 0; i < n; i++) {
            if (chess[i][col]) return false;
        }

        // 대각선 검사 \
        int min = Math.min(row, col);
        int checkRow = row - min;
        int checkCol = col - min;
        for (int i = 0; i < n; i++) {
            if (checkRow >= n || checkCol >= n) break;
            if (chess[checkRow][checkCol]) return false;
            checkRow++; checkCol++;
        }

        // 대각선 / 위쪽 검사
        checkRow = row;
        checkCol = col;
        for (int i = 0; i < n; i++) {
            if (checkRow < 0 || checkCol >= n) break;
            if (chess[checkRow][checkCol]) return false;
            checkRow--;
            checkCol++;
        }
        // 대각선 / 아래 검사
        checkRow = row;
        checkCol = col;
        for (int i = 0; i < n; i++) {
            if (checkCol < 0 || checkRow >= n) break;
            if (chess[checkRow][checkCol]) return false;
            checkRow++;
            checkCol--;
        }
        return true;
    }
}




