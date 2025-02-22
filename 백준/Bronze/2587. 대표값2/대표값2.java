import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            total += n;
            list.add(n);
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(total/list.size());
        System.out.println(list.get(list.size()/2));


        br.close();
    }

}
