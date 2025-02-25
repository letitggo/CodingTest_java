import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> findByInt = new HashMap<>();
        HashMap<String, Integer> findByName = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            findByInt.put(i + 1, name);
            findByName.put(name, i + 1);
        }

        for (int i = 0; i < m; i++) {
            String q = br.readLine();
            Integer key;
            try {
                key = Integer.parseInt(q) ;
                System.out.println(findByInt.get(key));
            } catch (Exception e) {
                System.out.println(findByName.get(q));
            }
        }

        br.close();
        bw.close();
    }
}
