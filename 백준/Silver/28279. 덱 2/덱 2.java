import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollFirst());
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.pollLast());
                    break;
                case 5:
                    System.out.println(deque.size());
                    break;
                case 6:
                    int value;
                    value = deque.isEmpty() ? 1 : 0;
                    System.out.println(value);
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekFirst());
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.peekLast());
                    break;
            }
        }
        br.close();
        bw.close();
    }
}





