import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr = new int[21][21][21];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = 0, b = 0, c = 0;
        String s;
        while ((s = br.readLine()) != null) {
            String[] split = s.split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            c = Integer.parseInt(split[2]);
            if (a == -1 && b == -1 && c == -1)
                break;
            int answer = w(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + answer);
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i <= 0 || j <= 0 || k <= 0) {
                        arr[i][j][k] = 1;
                    }
                }
            }
        }

        if (a > 20 || b > 20 || c > 20)
            a = b = c = 20;

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < 21; k++) {
                    if (i < j && j < k)
                        arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
                    else
                        arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                }
            }
        }

        return arr[a][b][c];
    }
}
