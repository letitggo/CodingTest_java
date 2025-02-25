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

        ArrayList<String> list = new ArrayList<>();
        
        // 보도 못한 사람을 입력받으며 보도 못했는지 확인 후 리스트에 add
        for (int i = 0; i < neverSeenN; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                list.add(name);
            }
        }

        // 사전순으로 정렬
        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + "\n");
        }

        bw.write(list.size() + "\n" + sb);

        br.close();
        bw.close();
    }
}
