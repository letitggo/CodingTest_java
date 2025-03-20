import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            freqMap.put(str, freqMap.getOrDefault(str, 1) + 1);
        }

        ArrayList<String> list = new ArrayList<>(freqMap.keySet());
        List<String> sorted = sort(list, freqMap);

        StringBuilder sb = new StringBuilder();
        for (String s : sorted) {
            sb.append(s).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
    }

    private static List<String> sort(List<String> list, Map<String, Integer> freqMap) {
        list.sort((o1, o2) -> {
            if (!(freqMap.get(o1) == freqMap.get(o2))) {
                return freqMap.get(o2) - freqMap.get(o1);
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        return list;
    }
}
