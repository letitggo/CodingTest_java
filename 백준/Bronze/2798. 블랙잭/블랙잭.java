import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int answer = 0;
        int c1, c2, c3;
        String str = br.readLine();
        String[] arr = str.split(" ");

        for (int i = 0; i < n; i++) {
            c1 = Integer.parseInt(arr[i]);
            for (int j = i + 1; j < n; j++) {
                c2 = Integer.parseInt(arr[j]);
                for (int k = j + 1; k < n; k++) {
                    c3 = Integer.parseInt(arr[k]);
                    if (c1 + c2 + c3 > answer && c1 + c2 + c3 <= max)
                        answer = c1 + c2 + c3;
                }
            }
        }

        System.out.println(answer);

        bw.close();
        br.close();
    }

}
