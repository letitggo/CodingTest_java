import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int days = (int) Math.ceil((double) remaining / speeds[i]);
            daysQueue.offer(days);
        }

        int currentMax = daysQueue.poll();
        int count = 1;

        while (!daysQueue.isEmpty()) {
            int nextDays = daysQueue.poll();
            
            if (nextDays > currentMax) {
                answerList.add(count);
                currentMax = nextDays;
                count = 1;
            } else {
                count++;
            }
        }
        answerList.add(count);

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
