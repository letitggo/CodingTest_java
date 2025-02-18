import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int maxX = -10000;
        int minX = 10000;
        int maxY = -10000;
        int minY = 10000;

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x >= maxX){
                maxX = x;
            }
            if (x <= minX) {
                minX = x;
            }
            if (y >= maxY){
                maxY = y;
            }
            if (y <= minY) {
                minY = y;
            }
        }

        System.out.println((maxX-minX) * (maxY-minY));

        bw.close();
        br.close();
    }

}
