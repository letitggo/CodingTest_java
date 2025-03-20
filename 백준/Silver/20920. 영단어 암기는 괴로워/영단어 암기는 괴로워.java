import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        Map<String, Integer> freqMap = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            freqMap.put(str, freqMap.getOrDefault(str, 1) + 1);
            if (freqMap.get(str) > maxFreq) maxFreq = freqMap.get(str);
            set.add(str);
        }

        ArrayList<String> list = new ArrayList<>(set);
        List<String> sorted = sort(list, freqMap);

        StringBuilder sb = new StringBuilder();
        for (int i = sorted.size() - 1; i >= 0; i--) {
            sb.append(sorted.get(i)).append("\n");
        }
        bw.write(sb + "");

        bw.flush();
    }

    private static List<String> sort(List<String> list, Map<String, Integer> freqMap) {
        Comparator<String> com1 = Comparator.comparing(freqMap::get);
        Comparator<String> com2 = Comparator.comparing(String::length);
        list.sort(com1.thenComparing(com2).thenComparing(Comparator.reverseOrder()));
        return list;
    }
}
