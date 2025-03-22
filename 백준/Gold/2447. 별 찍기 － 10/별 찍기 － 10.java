import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] init = init(n);
        String[][] an = solution(init, 0, 0, init.length, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(an[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }

    private static String[][] solution(String[][] target, int row, int col, int length, boolean isCenter) {
        if (isCenter) {
            for (int i = row; i < row + length; i++) {
                for (int j = col; j < col + length; j++) {
                    target[i][j] = " ";
                }
            }
            return target;
        }

        if (length == 1) {
            target[row][col] = "*";
            return target;
        }

        int nextLength = length/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean center = i == 1 && j == 1;
                solution(
                        target,
                        row + i * nextLength,
                        col + j * nextLength,
                        nextLength,
                        center
                );
            }
        }
        
        return target;
    }

    private static String[][] init(int n) {
        String[][] init = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                init[i][j] = " ";
            }
        }
        return init;
    }
}




