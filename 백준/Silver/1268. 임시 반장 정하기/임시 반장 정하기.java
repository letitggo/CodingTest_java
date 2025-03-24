import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(arr, n) + 1);
    }

    private static int solution(int[][] arr, int n) {

        int max = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int target = arr[i][j];
                for (int k = 0; k < n; k++) {
                    if (arr[k][j] == target && i != k) set.add(k);
                }
            }
            if (max < set.size()){
                max = set.size();
                answer = i;
            }
            set.clear();
        }
        return answer;
    }
}
