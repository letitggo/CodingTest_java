import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();

        // init
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(i, value));
        }

        StringBuilder sb = new StringBuilder();

        Balloon target = deque.removeFirst();

        for (int i = 0; i < n - 1; i++) {

            sb.append(target.index + 1).append(" ");

            if (target.value >0){
                for (int j = 0; j < target.value - 1; j++) {
                    deque.addLast(deque.removeFirst());
                }
                target = deque.removeFirst();
            } else{
                for (int j = 0; j < Math.abs(target.value) - 1; j++) {
                    deque.addFirst(deque.removeLast());
                }
                target = deque.removeLast();
            }
        }

        sb.append(target.index + 1);
        System.out.println(sb);

        br.close();
        bw.close();
    }
}

class Balloon{
    int index;
    int value;

    public Balloon(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
