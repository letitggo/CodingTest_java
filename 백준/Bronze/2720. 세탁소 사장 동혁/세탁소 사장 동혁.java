import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            int[] answer = {0, 0, 0, 0};
            int k = 0;
            while (true) {
                answer[k] = money/coins[k];
                money = money%coins[k];
                k++;
                if(money == 0)
                    break;
            }
            for (int j = 0; j < 4; j++) {
                System.out.print(answer[j] + " ");
            }
            System.out.println();
        }

        br.close();
        bw.close();

    }
}