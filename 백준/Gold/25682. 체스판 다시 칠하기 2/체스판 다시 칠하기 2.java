import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 행
        int m = Integer.parseInt(st.nextToken());   // 열
        int k = Integer.parseInt(st.nextToken());   // 정사각형 크기

        char[][] chess = new char[n + 1][m + 1];
        int[][] startW = new int[n + 1][m + 1];
        int[][] startB = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i + 1][j + 1] = s.charAt(j);
            }
        }

        // w, b 시작 체스판 다시 칠해야하 하는 부분 표시
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // W
                if ((i + j) % 2 == 0) {
                    if (chess[i][j] != 'W')
                        startW[i][j] = 1;
                    else
                        startB[i][j] = 1;
                } else {
                    if (chess[i][j] != 'B')
                        startW[i][j] = 1;
                    else
                        startB[i][j] = 1;
                }
            }
        }

        // 누적 합 구하기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                startW[i][j] = startW[i][j] + startW[i - 1][j] + startW[i][j - 1] - startW[i - 1][j - 1];
                startB[i][j] = startB[i][j] + startB[i - 1][j] + startB[i][j - 1] - startB[i - 1][j - 1];
            }
        }

        // k * k 체스판에서 다시 칠할 최소값 구하기
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n - k + 2; i++) {
            for (int j = 1; j < m - k + 2; j++) {
                int sX = i;
                int sY = j;
                int eX = sX + k - 1;
                int eY = sY + k - 1;
                int wCnt = startW[eX][eY] - (startW[eX][sY - 1] + startW[sX - 1][eY]) + startW[sX - 1][sY - 1];
                int bCnt = startB[eX][eY] - (startB[eX][sY - 1] + startB[sX - 1][eY]) + startB[sX - 1][sY - 1];
                answer = Math.min(Math.min(wCnt, bCnt), answer);
            }
        }
        System.out.println(answer);
    }
}