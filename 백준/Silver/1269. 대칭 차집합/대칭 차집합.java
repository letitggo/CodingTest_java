import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        int intersectionE = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                intersectionE++;
            }
        }

        bw.write(aNum + bNum - intersectionE * 2 + "");

        br.close();
        bw.close();
    }
}
