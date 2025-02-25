import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int neverHeardN = Integer.parseInt(st.nextToken());
        int neverSeenN = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < neverHeardN; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (int i = 0; i < neverSeenN; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> answerList = new ArrayList<>();
        map.forEach((s, integer) -> {
            if (integer >= 2){
                answerList.add(s);
            }
        });

        answerList.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : answerList) {
            sb.append(s + "\n");
        }

        bw.write(answerList.size() + "\n" + sb);

        br.close();
        bw.close();
    }
}
