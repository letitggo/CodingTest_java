import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i = 0;
        int sum = 0;
        boolean isFind = false;

        while (true) {
            sum = 0;
            String toStr = String.valueOf(i);
            for (int j = 0; j < toStr.length(); j++) {
                int k = Integer.parseInt(String.valueOf(toStr.charAt(j)));
                sum += k;
            }
            sum += i;
            if (sum == n){
                isFind = true;
                break;
            }
            i++;
            if (i > n) {
                break;
            }
        }
        if (isFind)
            System.out.println(i);
        else
            System.out.println(0);


        br.close();
    }

}
