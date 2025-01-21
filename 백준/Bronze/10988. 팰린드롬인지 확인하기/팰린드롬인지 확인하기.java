import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuffer sb = new StringBuffer(str);

        if (str.contentEquals(sb.reverse())) {
            bw.write("1");
        }else {
            bw.write("0");
        }

        br.close();
        bw.close();
    }
}