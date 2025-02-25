import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> logSet = new HashSet<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <n; i++) {
            String[] str = br.readLine().split(" ");
            if (str[1].equals("enter")) {
                logSet.add(str[0]);
            } else {
                logSet.remove(str[0]);
            }
        }

        List<String> list = logSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }
}
