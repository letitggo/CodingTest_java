import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1000;
        int positiveSum = 0;
        int negativeSum = 0;
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            max = Math.max(max, target);
            if (target > 0) {
                if (negativeSum < 0){
                    list.add(negativeSum);
                    negativeSum = 0;
                }
                positiveSum += target;
            } else {
                if (positiveSum > 0){
                    list.add(positiveSum);
                    max = Math.max(max, positiveSum);
                    positiveSum = 0;
                }
                negativeSum += target;
            }
        }
        if (positiveSum != 0){
            list.add(positiveSum);
            max = Math.max(max, positiveSum);
        }
        if (negativeSum != 0){
            list.add(negativeSum);
            max = Math.max(max, negativeSum);
        }

        if (max < 0) {
            System.out.println(max);
        } else {
            int sum = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (sum + list.get(i) > 0) {
                    sum += list.get(i);
                } else {
                    i++;
                    if( i < list.size())
                        sum = list.get(i);
                }
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
    }
}
