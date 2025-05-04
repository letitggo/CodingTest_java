import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int arr[][];
    static int[] answers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][5];
        answers = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            solution(i);
        }

        int max = 0;
        int answer = 1;
        for (int i = 0; i < n; i++) {
            if (max <= answers[i]) {
                max = answers[i];
                answer = i + 1;
            }
        }
        System.out.println(answer);
    }

    private static void solution(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k <5; k++) {
                    int value = arr[num][i] + arr[num][j] + arr[num][k];
                    answers[num] = Math.max(value % 10, answers[num]);
                }
            }
        }
    }
}
