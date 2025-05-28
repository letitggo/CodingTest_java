import java.util.*;
class Solution {
    static boolean[] visited = new boolean[101];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        int answer = n;

        int max = 0;
        int min = n;
        for (int i = 0; i <= 100; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {
            for (int j = 0; j <= 100; j++) {
                if (!visited[j] && !graph.get(j).isEmpty()) {
                    int result = dfs(n, wire, j, 1);
                    max = Math.max(max, result);
                    min = Math.min(min, result);
                }
            }
            answer = Math.min(max - min, answer);
            Arrays.fill(visited, false);
            max = 0;
            min = n;
        }

        return answer;
    }

    private static int dfs(int n, int[] targetWire, int cur, int depth) {
        visited[cur] = true;

        for (int e : graph.get(cur)) {
            if (!visited[e]) {
                if ((cur == targetWire[0] && e == targetWire[1]) || (e == targetWire[0] && cur == targetWire[1])) continue;
                depth = (dfs(n, targetWire, e, depth + 1));
            }
        }
        return depth;
    }
}