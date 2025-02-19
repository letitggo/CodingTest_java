import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 세 변 중 길이가 가장 긴 변
        int max = Math.max(a, Math.max(b, c));
        // 나머지 두 변의 합
        int remain = a + b + c - max;

        if (max >= remain) {
            max = remain - 1;
        }

        System.out.println(max + remain);

        bw.close();
        br.close();
    }

}
