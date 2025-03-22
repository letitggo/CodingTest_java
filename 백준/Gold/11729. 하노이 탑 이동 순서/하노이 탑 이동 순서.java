import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        move(n, 0, 2, sb);

        System.out.println(sb.length()/4);
        bw.write(sb + "");
        bw.flush();
    }

    private static int move(int n, int from, int to, StringBuilder sb) {
        int nextFrom = (from % 3);
        int nextTo = (to % 3);
        if (nextFrom == nextTo) nextTo = (nextTo + 1) % 3;
        if (n == 0) return nextTo;

        int movedTo = move(n - 1, nextFrom, nextTo + 1, sb);
        sb.append(nextFrom+1).append(" ").append(nextTo+1).append("\n");
        move(n-1, movedTo, nextTo, sb);

        return nextTo;
    }
}
