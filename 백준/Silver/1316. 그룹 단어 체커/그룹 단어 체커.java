import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String pre = "";
            int k;
            int[] arr = new int[26];
            
            for (k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                if (arr[c - 'a'] == 1) {
                    if (pre.equals(String.valueOf(c))) {
                        continue;
                    }else {
                        break;
                    }
                }
                arr[c - 'a'] = 1;
                pre = String.valueOf(c);
            }
            if (k >= s.length()) {
                answer++;
            }

        }

        bw.write(answer + "");

        br.close();
        bw.close();

    }
}