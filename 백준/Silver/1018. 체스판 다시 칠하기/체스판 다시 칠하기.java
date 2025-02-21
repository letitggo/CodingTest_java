import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int answer = 64;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int startW = 0;
                int startB = 0;
                for (int row = i; row < 8 + i; row++) {
                    for (int col = j; col < 8 + j; col++) {
                        char target = arr[row].charAt(col);

                        if (row % 2 == 0){
                            if (col % 2== 0) {
                                if (target == 'B') startW++;
                                if (target == 'W') startB++;
                            }
                            if (col % 2 != 0) {
                                if (target == 'W') startW++;
                                if (target == 'B') startB++;
                            }
                        } else {
                            if (col % 2 == 0) {
                                if (target == 'W') startW++;
                                if (target == 'B') startB++;
                            }
                            if (col % 2 != 0) {
                                if (target == 'B') startW++;
                                if (target == 'W') startB++;
                            }
                        }
                    }
                }
                int min = Math.min(startW, startB);
                if (min < answer){
                    answer = min;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

}
