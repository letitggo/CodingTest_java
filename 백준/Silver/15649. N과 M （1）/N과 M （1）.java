import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[n];
        solution(check, "", m, 0);
    }

    private static void solution(boolean[] check, String s, int m, int found) {
        if (found == m) {
            System.out.println(s);
            return;
        }
        found += 1;
        for (int i = 0; i < check.length; i++) {
            if (!check[i]){
                check[i] = true;
                solution(check, s + (i + 1) + " ", m, found);
                check[i] = false;
            }
        }
    }
}




