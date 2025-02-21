import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int start =665;
        int cnt = 0;

        while (true) {
            start++;

            String target = String.valueOf(start);
            if(target.contains("666")){
                cnt++;
            }

            if (cnt == n) {
                System.out.println(start);
                break;
            }


        }

        br.close();
    }

}
