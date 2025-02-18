import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            int total = n1 + n2 + n3;
            int max = Math.max(n1, Math.max(n2, n3));
            if (n1 == 0 && n2 == 0 && n3 == 0) {
                break;
            }
            if (max < total - max) {
                if (n1 == n2 && n1 == n3 && n2 == n3) {
                    System.out.println("Equilateral");
                } else {
                    if (n1 != n2 && n1 != n3 && n2 != n3) {
                        System.out.println("Scalene");
                    } else {
                        System.out.println("Isosceles");
                    }
                }
            } else {
                System.out.println("Invalid");
            }
        }





        bw.close();
        br.close();
    }

}
