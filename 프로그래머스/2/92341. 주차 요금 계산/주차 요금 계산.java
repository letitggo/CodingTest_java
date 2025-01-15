import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = new int[10000];
        int[] parkingTimeArr = new int[10000];

        Map<String, String> recodeMap = new HashMap<>();

        for (String recode : records) {
            String[] recodeS = recode.split(" ");
            // IN 이면
            if(recodeS[2].equals("IN")) {
                recodeMap.put(recodeS[1], recodeS[0]);
            // OUT 이면
            }else{
                String[] IN = recodeMap.get(recodeS[1]).split(":");
                String[] OUT = recodeS[0].split(":");

                int hour = Integer.parseInt(OUT[0]) - Integer.parseInt(IN[0]);
                int minute = Integer.parseInt(OUT[1]) - Integer.parseInt(IN[1]);
                int parkingTime = hour * 60 + minute;

                parkingTimeArr[Integer.parseInt(recodeS[1])] += parkingTime;
                recodeMap.remove(recodeS[1]);
            }
        }

        if (!recodeMap.isEmpty()) {
            for (String k : recodeMap.keySet()) {
                String[] IN = recodeMap.get(k).split(":");
                String[] OUT = "23:59".split(":");

                int hour = Integer.parseInt(OUT[0]) - Integer.parseInt(IN[0]);
                int minute = Integer.parseInt(OUT[1]) - Integer.parseInt(IN[1]);
                int parkingTime = hour * 60 + minute;

                parkingTimeArr[Integer.parseInt(k)] += parkingTime;
            }
        }

        // 혹은 이터레이터 사용하기
        // hashMap같은 경우 해당 컬렉션을 반복하는 동안 수정할 경우 ConcurrentModificationException예외 발생
        // 따라서 iterator를 사용하여 안전하게 remove() 수행
        /**
        Iterator<String> iterator = recodeMap.keySet().iterator();
        while (iterator.hasNext()) {
            String k = iterator.next();
            String[] IN = recodeMap.get(k).split(":");
            String[] OUT = "23:59".split(":");

            int hour = Integer.parseInt(OUT[0]) - Integer.parseInt(IN[0]);
            int minute = Integer.parseInt(OUT[1]) - Integer.parseInt(IN[1]);
            int parkingTime = hour * 60 + minute;

            parkingTimeArr[Integer.parseInt(k)] += parkingTime;
            iterator.remove(); // 안전하게 제거
        }
        **/

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 9999; i++) {
            if(parkingTimeArr[i] > 0) {
                if (parkingTimeArr[i] < fees[0] && parkingTimeArr[i] != 0) {
                    answer[i] += fees[1];
                }else{
                    if ((parkingTimeArr[i] - fees[0]) % fees[2] != 0) {
                        answer[i] += (((parkingTimeArr[i] - fees[0]) / fees[2]) + 1) * fees[3] + fees[1];
                    }else{
                        answer[i] += ((parkingTimeArr[i] - fees[0]) / fees[2]) * fees[3] + fees[1];
                    }
                }
                list.add(answer[i]);
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        return a;
    }
}
