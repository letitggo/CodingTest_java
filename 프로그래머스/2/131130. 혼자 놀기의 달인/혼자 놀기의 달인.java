import java.util.Arrays;
class Solution {
    public int solution(int[] cards) {

        int answer = 0;

        int[] visited = new int[cards.length];
        int[] boxGroup = new int[cards.length];
        int count = 0;
        int start;

        while (true) {
            if(notVisited(cards, visited) == -1) break;
            start = notVisited(cards, visited);         // 0

            while (visited[start] == 0) {
                visited[start] = 1;
                boxGroup[count] ++;
                start = cards[start]-1;
            }
            count++;
        }

        if(count == 1) return answer;

        Arrays.sort(boxGroup);
        answer = boxGroup[cards.length-1] * boxGroup[cards.length-2];
        return answer;

    }

    int notVisited(int[] arr, int[] visited) {
        for (int i = 0; i < arr.length; i++) {
            if(visited[i] == 0) return i;
        }
        return -1;
    }
}