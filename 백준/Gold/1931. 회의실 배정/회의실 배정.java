import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] rooms = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms[i][0] = start;
            rooms[i][1] = end;
        }

        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int next = rooms[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (rooms[i][0] >= next){
                next = rooms[i][1];
                ans++;
            }
        }

        System.out.println(ans);
    }
}