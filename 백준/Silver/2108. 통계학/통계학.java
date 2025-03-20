import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int freq = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            sum += target;
            map.put(target, map.getOrDefault(target, 0) + 1);
            list.add(target);
            if (map.get(target) > freq) {
                freq = map.get(target);
            }
            if (target > max){
                max = target;
            }
            if (target < min) {
                min = target;
            }
        }
        list.sort(Comparator.naturalOrder());
        ArrayList<Integer> freqList = new ArrayList<>();
        int finalFreq = freq;
        map.forEach((key, value) -> {
            if (value == finalFreq) {
                freqList.add(key);
            }
        });
        freqList.sort(Comparator.naturalOrder());

        System.out.println(Math.round((float) sum /n));
        System.out.println(list.get(list.size()/2));
        if (freqList.size() == 1) {
            System.out.println(freqList.get(0));
        }else
            System.out.println(freqList.get(1));
        System.out.println(max - min);
    }
}




