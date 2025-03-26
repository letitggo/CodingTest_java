import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, count;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(0, 0, 0);
        System.out.println(count);
    }

    private static void backtrack(int index, int sum, int selectedCnt) {
        if (index == N) {
            if (selectedCnt > 0 && sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소 포함
        backtrack(index + 1, sum + nums[index], selectedCnt + 1);

        // 현재 원소 제외
        backtrack(index + 1, sum, selectedCnt);
    }
}
