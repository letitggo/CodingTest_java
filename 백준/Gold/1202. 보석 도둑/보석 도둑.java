import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 보석의 수
        int k = Integer.parseInt(st.nextToken());   // 가방의 수
        int[][] mv = new int[n][2];
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            mv[i][0] = m;
            mv[i][1] = v;
        }
        Arrays.sort(mv, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];  // 1. 가치 내림차순  2. 질량 오름차순
            }
        });

        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            int value = Integer.parseInt(br.readLine());
            bags[i] = value;
        }
        Arrays.sort(bags);

        long totalValue = 0;
        int mvIndex = 0;
        for (int bag : bags) {
            while (mvIndex < n && mv[mvIndex][0] <= bag) {
                queue.add(mv[mvIndex++][1]);
            }
            if (!queue.isEmpty()) totalValue += queue.poll();
        }
        System.out.println(totalValue);
    }

    static boolean search(int m, int[] bags) {
        int low = 0;
        int high = bags.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bags[mid] >= m) {
                return true;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
