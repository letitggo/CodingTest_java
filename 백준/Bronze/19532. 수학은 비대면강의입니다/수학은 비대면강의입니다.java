import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());
        double d = Integer.parseInt(st.nextToken());
        double e = Integer.parseInt(st.nextToken());
        double f = Integer.parseInt(st.nextToken());

        System.out.println((int)((c * e - b * f) / (a * e - b * d)) + " " + (int)((a*f - c*d) / (a * e - b * d)));
        br.close();
    }

}
