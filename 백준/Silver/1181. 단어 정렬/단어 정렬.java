import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, (s1, s2) -> {
            if (s1.length() == s2.length()){
                return s1.compareTo(s2);
            }
            return Integer.compare(s1.length(), s2.length());
        });



        for (int i = 0; i < str.length; i++) {
            if (i < n-1 && str[i].equals(str[i + 1])) {
                continue;
            }
            System.out.println(str[i]);
        }

        br.close();
        bw.close();
    }

}
