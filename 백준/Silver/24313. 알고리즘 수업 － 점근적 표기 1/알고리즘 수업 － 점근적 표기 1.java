import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        if ((n0 * a1 + a0) <= (c * n0)){
            n0 = 100;
            if ((n0 * a1 + a0) <= (c * n0)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }else {
            System.out.println(0);
        }

        bw.close();
        br.close();
    }

}
