import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int j = 0; j <= (n - 1) / 10; j++) {
                int[] temp = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int k = 0; k < temp.length; k++) {
                    arr[j * 10 + k] = temp[k];
                }
            }
            sb.append((n + 1) / 2).append("\n");

            Queue<Integer> lowerHeap = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Integer> largerHeap = new PriorityQueue<>();

            for (int j = 0; j < n; j++) {
                int value = arr[j];
                if (lowerHeap.isEmpty() || lowerHeap.peek() > value) {
                    lowerHeap.offer(value);
                } else
                    largerHeap.offer(value);

                if (largerHeap.size() > lowerHeap.size()) {
                    lowerHeap.offer(largerHeap.poll());
                } else if (lowerHeap.size() > largerHeap.size() + 1){
                    largerHeap.offer(lowerHeap.poll());
                }

                if (j % 2 == 0) {
                    sb.append(lowerHeap.peek()).append(" ");
                }
                if ((j + 1) % 20 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
