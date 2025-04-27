import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 도시의 수

        long remain = 0;
        int[] road = new int[n + 1];  // 도로의 길이
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            remain += road[i];
        }

        int minIdx = 1;
        int[] prices = new int[n + 1];  // 리터당 기름 가격
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            if (prices[i] < prices[i - 1] && i != n)
                minIdx = i;
        }
        prices[n] = Integer.MAX_VALUE;

        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (i == minIdx) {
                ans += (long) prices[i] * remain;
                System.out.println(ans);
                return;
            } else {
                ans += (long) prices[i] * road[i];
                remain -= road[i];
                int curPrice = prices[i];
                for (int j = i + 1; j < n; j++) {
                    if (curPrice < prices[j]) {
                        ans += (long) curPrice * road[j];
                        remain -= road[j];
                        i++;
                    } else
                        break;
                }
            }
        }
        System.out.println(ans);

    }
}