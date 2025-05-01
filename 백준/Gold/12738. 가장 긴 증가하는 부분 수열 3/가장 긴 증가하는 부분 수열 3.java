import java.io.*;
import java.util.*;

public class Main {
    static int n;   // 수열의 길이
    static int[] arr;
    static ArrayList<Integer> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : arr) {
            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                int idx = search(num);
                lis.set(idx, num);
            }
        }
        System.out.println(lis.size());
    }

    static int search(int target) {
        int low = 0;
        int high = lis.size() - 1;
        int idx = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (lis.get(mid) >= target) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}
