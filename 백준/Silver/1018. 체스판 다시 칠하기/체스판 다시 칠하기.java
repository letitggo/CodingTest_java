import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[][] arr = new String[50][50];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int row = 0; row < n - 7; row++ ){
            for (int col = 0; col < m - 7; col++) {
                int cnt = 0;
                String start = "W";
                for (int i = row; i < 8 + row; i++) {
                    for (int j = col; j < 8 + col; j++) {
                        String target = arr[i][j];
                        if (i % 2 == 0) {
                            if (j % 2 == 0) {
                                if (!start.equals(target)) {
                                    cnt++;
                                }
                            } else {
                                if (start.equals(target)) {
                                    cnt++;
                                }
                            }
                        } else {
                            if (j % 2 == 0) {
                                if (start.equals(target)) {
                                    cnt++;
                                }
                            } else {
                                if (!start.equals(target)) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
                if (cnt < answer) {
                    answer = cnt;
                }
                start = "B";
                cnt = 0;
                for (int i = row; i < 8 + row; i++) {
                    for (int j = col; j < 8 + col; j++) {
                        String target = arr[i][j];
                        if (i % 2 == 0) {
                            if (j % 2 == 0) {
                                if (!start.equals(target)) {
                                    cnt++;
                                }
                            } else {
                                if (start.equals(target)) {
                                    cnt++;
                                }
                            }
                        } else {
                            if (j % 2 == 0) {
                                if (start.equals(target)) {
                                    cnt++;
                                }
                            } else {
                                if (!start.equals(target)) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
                if (cnt < answer) {
                    answer = cnt;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

}
