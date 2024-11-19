import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> friendsIndex = new HashMap<>();
        int[][] giftIndex = new int[friends.length][friends.length];
        int[] giftRatio = new int[friends.length];
        int[] answers = new int[friends.length];


        // init
        for (int i = 0; i < friends.length; i++) {
            friendsIndex.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String from = gift[0];
            giftRatio[friendsIndex.get(from)]++;
            String to = gift[1];
            giftRatio[friendsIndex.get(to)]--;
            giftIndex[friendsIndex.get(from)][friendsIndex.get(to)]++;
        }
        // ================================================

        for (int i = 0; i < giftIndex.length; i++) {
            for (int j = i+1; j < giftIndex.length; j++) {

                if(i == j) continue;
                int iToj = giftIndex[i][j];
                int jToi = giftIndex[j][i];

                if (iToj == jToi) {
                    int iRatio = giftRatio[i];
                    int jRatio = giftRatio[j];
                    if(iRatio > jRatio) {
                        answers[i]++;
                    } else if (jRatio > iRatio) {
                        answers[j]++;
                    }
                }else {
                    if(iToj > jToi) {
                        answers[i]++;
                    }else{
                        answers[j]++;
                    }
                }
            }
        }


        int max = answers[0];
        for (int i = 1; i < answers.length; i++) {
            if(max < answers[i]) max = answers[i];
        }

        return max;
    }
}