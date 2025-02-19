import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());


        System.out.println((n*(n-1) * (n-2))/6);
        System.out.println(3);

        bw.close();
        br.close();


    }

}
