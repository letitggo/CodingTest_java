import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String str = br.readLine();

        for (int i = 1; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String sub1 = str.substring(0, i);
                String sub2 = str.substring(i, j);
                String sub3 = str.substring(j, str.length());
                String reversed = revers(new String[]{sub1, sub2, sub3});
                list.add(reversed);
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0));
    }

    private static String revers(String[] sub) {
        StringBuilder append = new StringBuilder();
        StringBuilder sb;
        for (int i = 0; i < sub.length; i++) {
            sb = new StringBuilder(sub[i]);
            append.append(sb.reverse());
        }
        return append.toString();
    }
}
