import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long low = 1;
        long high = arr[arr.length-1];
        long best = 0;

        while(low <= high) {
            long mid = (low + high) >>> 1;
            long cnt = compute(mid);

            if(cnt >= n) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return best;
    }

    static long compute(long length) {
        long sum = 0;
        for(int lan : arr) {
            sum += lan / length;
        }
        return sum;
    }
}
