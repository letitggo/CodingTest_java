import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                heap.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            heap.poll();
        }
        System.out.println(heap.poll());
    }
}
