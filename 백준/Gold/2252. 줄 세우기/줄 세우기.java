import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		Integer N = Integer.parseInt(st.nextToken());
		Integer M = Integer.parseInt(st.nextToken());
		
		int[] inDegree = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			graph.add(list);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(to);
			inDegree[to]++;
		}
		
		for(int i = 1; i < N + 1; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node).append(" ");
			
			graph.get(node).forEach(it -> {
				inDegree[it]--;
				if(inDegree[it] == 0) {
					queue.add(it);
				}
			});
			graph.get(node).clear();
		}
		
		System.out.println(sb);
	}
;}
