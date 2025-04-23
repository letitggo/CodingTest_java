import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char[] str = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int[][] freq = new int[26][str.length + 1];

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            for (int j = 0; j < 26; j++) {
                freq[j][i + 1] = freq[j][i];
            }
            freq[c - 'a'][i + 1] = freq[c - 'a'][i] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char[] c = st.nextToken().toCharArray();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(freq[c[0] - 'a'][end + 1] - freq[c[0] - 'a'][start]).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}