

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] acidity; // 신맛
    static int[] acerbity; // 쓴맛
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        acerbity = new int[n];
        acidity = new int[n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            acidity[i] = Integer.parseInt(st.nextToken());
            acerbity[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(1, 0, 0);
        System.out.println(min);
    }

    private static void backtrack(int totalAcidity, int totalAcerbity, int depth) {
        if (depth >= n) return;
        int currentAcidity = totalAcidity * acidity[depth];
        int currentAcerbity = totalAcerbity + acerbity[depth];
        if (Math.abs(currentAcidity - currentAcerbity) < min){
            min = Math.abs(currentAcidity - currentAcerbity);
        }

        backtrack(totalAcidity * acidity[depth], totalAcerbity + acerbity[depth], depth + 1);
        backtrack(totalAcidity, totalAcerbity, depth + 1);
    }


}
