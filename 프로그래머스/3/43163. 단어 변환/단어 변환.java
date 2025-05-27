import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public int solution(String begin, String target, String[] words) {

        for (int i = 0; i < words.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < begin.length(); i++) {
            for (int j = 0; j < 26; j++) {
                StringBuilder sb = new StringBuilder(begin);
                sb.replace(i, i + 1, String.valueOf(Character.toChars('a' + j)));
                for (int k = 0; k < words.length; k++) {
                    if (sb.toString().equals(words[k])) {
                        graph.get(0).add(k + 1);
                    }
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            addGraph(words[i], words, graph, i);
        }

        int answer = 0;

        visited = new boolean[words.length + 1];
        int[] u = {0, 0};
        queue.add(u);
        visited[0] = true;

        answer = bfs(words, target);

        return answer;
    }

    private static int bfs(String[] words, String target){
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            for (int e : graph.get(u[0])) {
                if (!visited[e]) {
                    visited[e] = true;
                    int[] v = {e, u[1] + 1};
                    queue.offer(v);
                    if (words[e - 1].equals(target)) {
                        return u[1] + 1;
                    }
                }
            }
        }
        return 0;
    }


    private void addGraph(String word, String[] words, ArrayList<ArrayList<Integer>> graph, int idx) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                StringBuilder sb = new StringBuilder(word);
                sb.replace(i, i + 1, String.valueOf(Character.toChars('a' + j)));
                for (int k = idx + 1; k < words.length; k++) {
                    if (sb.toString().equals(words[k]) && idx != k) {
                        graph.get(idx + 1).add(k + 1);
                        graph.get(k + 1).add(idx + 1);
                    }
                }
            }
        }
    }
}