import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (cnt == arr[i] && answer[j] == 0){
                    answer[j] = i + 1;
                    break;
                }
                if (answer[j] == 0 || answer[j] > i + 1) {
                    cnt++;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}