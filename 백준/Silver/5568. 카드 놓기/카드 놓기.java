import java.io.*;
import java.util.*;

public class Main {

    static List<String> cards = new ArrayList<>();
    static Set<String> distinct = new HashSet<>();
    static int n, k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            cards.add((br.readLine()));
        }

        boolean[] visited = new boolean[n];

        backtrack(visited, new ArrayList<>());

        System.out.println(distinct.size());
    }

    private static void backtrack(boolean[] visited, List<String> current) {
        if (current.size() == k) {
            distinct.add(String.join("", current));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(cards.get(i));
                backtrack(visited, current);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

}