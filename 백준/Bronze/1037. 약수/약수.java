import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            list.add(target);
        }

        list.sort(Comparator.naturalOrder());

        if (list.size() == 1) {
            System.out.println(list.get(0) * list.get(0));
        } else
            System.out.println(list.get(0) * list.get((n-1)));

    }
}




