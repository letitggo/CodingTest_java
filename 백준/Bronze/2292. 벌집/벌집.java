import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        int k = 1;

        while (true) {
            if(k >= n){
                break;
            }
            k = k + (answer * 6);
            answer++;
        }

        System.out.println(answer);

        br.close();
        bw.close();

    }
}