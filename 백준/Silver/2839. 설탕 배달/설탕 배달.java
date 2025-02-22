import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt3 = 0;
        int temp = n;
        int cnt5 = temp / 5;

        while (true) {
            for (int i = 0; i < cnt5; i++) {
                temp = temp - 5;
            }

            while (true) {
                if (temp - 3 >= 0) {
                    temp -= 3;
                    cnt3++;
                } else {
                    break;
                }
            }

            if (temp == 0) {
                System.out.println(cnt5 + cnt3);
                break;
            } else if (cnt5 < 0) {
                System.out.println(-1);
                break;
            }

            temp = n;
            cnt5--;
            cnt3 = 0;
        }
        br.close();
    }

}
