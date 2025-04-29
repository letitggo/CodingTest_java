import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(0, n - 1, target)).append("\n");
        }
        System.out.print(sb);
    }

    static int binarySearch(int start, int end, int target) {
        int mid = (start + end) / 2;

        if (start <= end) {
            if (target == array[mid])
                return 1;
            else if (target > array[mid]) {
                return binarySearch(mid + 1, end, target);
            } else {
                return binarySearch(start, mid - 1, target);
            }
        }
        return 0;
    }
}