import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        while(true){
            list.clear();
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            if(n == -1){
                break;
            }
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0){
                    list.add(i);
                    sum += i;
                }
            }
            if (sum != n) {
                System.out.println(n + " is NOT perfect.");
            } else {
                System.out.print(n + " = ");
                for (int i = 0; i < list.size() -1 ; i++) {
                    System.out.print(list.get(i) + " + ");
                }
                System.out.println(list.get(list.size()-1));
            }
        }

        bw.close();
        br.close();
    }
}
