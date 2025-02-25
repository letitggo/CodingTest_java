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

            // 정규식을 이용하여 숫자인지 확인하는 방법
            if (q.matches("\\d+")) {
                System.out.println(findByInt.get(Integer.parseInt(q)));
            } else {
                System.out.println(findByName.get(q));
            }

            /**  아스키코드를 이용하여 숫자인지 확인하는 방법 **/
            // if (49 <= S.charAt(0) && S.charAt(0) <= 57) ...

            /** Character 을 이용하여 숫자인지 확인하는 방법 **/
            // Character.isDigit(q.charAt(0));

            // 그냥 예외 때려잡는 방법.................은 구린듯
//            try {
//                key = Integer.parseInt(q) ;
//                System.out.println(findByInt.get(key));
//            } catch (Exception e) {
//                System.out.println(findByName.get(q));
//            }
        }

        br.close();
        bw.close();
    }
}
