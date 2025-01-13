class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = 0;

        int prevMid = 0;
        int mid = 500000;
        int low = 0;
        int high = 1000000;

        while (low <= high) {
            mid = low + (high - low) / 2;
            answer = getAnswer(diffs, times, mid, answer);

            if (answer > limit) {
                low = mid -1;
            }else {
                high = mid + 1;
            }
            if(prevMid == mid)
                break;
            prevMid = mid;
        }
        if (answer > limit) {
            mid++;
        }
        return mid;
    } 
    private static long getAnswer(int[] diffs, int[] times, int level, long answer) {
        answer = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                answer += times[i];
            }else{
                answer += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }
        }

        return answer;
    }
}