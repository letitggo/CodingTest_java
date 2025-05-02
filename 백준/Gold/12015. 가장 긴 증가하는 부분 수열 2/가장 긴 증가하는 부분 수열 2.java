import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static ArrayList<Integer> lis = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int value : arr) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < value) {
                lis.add(value);
            } else {
                int idx = search(value);
                lis.set(idx, value);
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
