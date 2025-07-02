import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    static int N;   // 사다리의 수
    static int M;   // 뱀의 수

    static Queue<int[]> queue = new LinkedList<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= 6; i++) {
            int next = 1 + i;
            visited[next] = true;
            if (snake.containsKey(next)) {
                next = snake.get(next);
            }
            if (ladder.containsKey(next)){
                next = ladder.get(next);
            }
            int[] temp = {next, 1};
            queue.offer(temp);
        }

        System.out.println(bfs());
    }

    private static int bfs(){

        while (!queue.isEmpty()) {
            int[] uv = queue.poll();

            if (uv[0] == 100){
                return uv[1];
            }

            for (int i = 1; i <= 6; i++) {
                int next = uv[0] + i;

                if (next <= 100 && !visited[next]) {
                    visited[next] = true;
                    if (snake.containsKey(next)) {
                        next = snake.get(next);
                    }
                    if (ladder.containsKey(next)) {
                        next = ladder.get(next);
                    }
                    int[] temp = {next, uv[1] + 1};
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }
}