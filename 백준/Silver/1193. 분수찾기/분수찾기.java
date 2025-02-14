import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = 1;
        int i = 1;

        while (true) {
            if(k > n) {
                break;
            }
            k = k + i;
            i++;
        }
        int x = k-n;
        if(i%2 == 0){
            System.out.println(x + "/" + (i - x));
        }else{
            System.out.println(i - x + "/" + x);
        }
        br.close();
        bw.close();

    }
}