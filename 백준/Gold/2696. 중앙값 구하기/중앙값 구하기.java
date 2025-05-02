import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> lowerHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> largerHeap = new PriorityQueue<>();
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int length = n / 10;
            if (n % 10 != 0)
                length++;
            int[] arr = new int[n];
            int idx = 0;
            for (int j = 0; j < length; j++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    arr[idx] = Integer.parseInt(st.nextToken());
                    idx++;
                }
            }
            if (n % 2 == 0) {
                sb.append(n / 2);
            }else
                sb.append((n / 2) + 1);
            sb.append("\n");
            for (int j = 0; j < n; j++) {
                largerHeap.offer(arr[j]);
                if (j % 2 == 0) {
                    for (int k = 0; k < largerHeap.size() / 2; k++) {
                        lowerHeap.offer(largerHeap.poll());
                    }
                    if (j % 20 == 0 && j != 0)
                        sb.append("\n");
                    sb.append(largerHeap.peek()).append(" ");
                    for (int k = 0; k < lowerHeap.size(); k++) {
                        largerHeap.offer(lowerHeap.poll());
                    }
                }

            }
            sb.append("\n");
            lowerHeap.clear();
            largerHeap.clear();
        }

        System.out.println(sb);
    }
}
