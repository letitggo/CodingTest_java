import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            StringBuilder sb = new StringBuilder();
            backtrack(0);
            System.out.println();
        }
    }

    private static void backtrack(int depth) {
        if(visited()) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (depth >= n)
            return;

        for (int i = depth; i < n; i++) {
            visited[i] = true;
            backtrack(i+1);
            visited[i] = false;
        }

    }

    private static boolean visited() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                cnt++;
            }
            if (cnt == 6) return true;
        }
        return false;
    }
}
