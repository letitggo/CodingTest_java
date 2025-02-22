import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            list.add(number);
        }

        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i) + "\n");
        }

        br.close();
        bw.close();
    }

}
