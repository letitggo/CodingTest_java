import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (i == kim - 1 || i == lim - 1) {
                list.add(1);
            }else
                list.add(0);
        }

        boolean meet = false;
        int count = 0;
        while (true) {
            List<Integer> temp = new ArrayList<>();
            count++;
            for (int i = 0; i < list.size() - 1; i+=2) {
                if(list.get(i) + list.get(i+1) == 2)  {
                    meet = true;
                    break;
                } else {
                    temp.add(list.get(i) + list.get(i + 1));
                }
            }
            temp.add(0);
            list = temp;
            if (meet) break;
        }
        System.out.println(count);
    }
}
