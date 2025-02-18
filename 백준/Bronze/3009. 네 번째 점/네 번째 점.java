import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }

        mapX.forEach((x, value) -> {
            if (value == 1)
                System.out.print(x + " ");
        });

        mapY.forEach((y, value) -> {
            if (value == 1)
                System.out.print(y + " ");
        });

        bw.close();
        br.close();
    }

}
