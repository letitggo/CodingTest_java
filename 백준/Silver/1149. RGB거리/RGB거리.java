import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1000000;
            arr[i][1] = 1000000;
            arr[i][2] = 1000000;
        }
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[0][1] = Integer.parseInt(st.nextToken());
        arr[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] value = new int[3];
            value[0] = Integer.parseInt(st.nextToken());
            value[1] = Integer.parseInt(st.nextToken());
            value[2] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k != j){
                        int target = value[k] + arr[i - 1][j];
                        if (target < arr[i][k])
                            arr[i][k] = target;
                    }
                }
            }
        }

        int answer = 1000000;
        for (int i = 0; i < 3; i++) {
            if (arr[n-1][i] < answer)
                answer = arr[n-1][i];
        }

        System.out.println(answer);

    }

}