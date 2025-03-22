import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if (n != 0){
                int pow = (int) Math.pow(3, n);
                String target = init(pow/3);
                sb.append(solution(target, pow)).append("\n");
                continue;
            }
            sb.append("-").append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }

    private static String solution(String target, int n) {
        n = n/3;
        if (n <= 0) return target;
        String substring1 = target.substring(0, n);
        String substring2 = target.substring(n, 2*n);
        String substring3 = target.substring(2*n, 3*n);
        return solution(substring1, n) + replace(substring2, n) + solution(substring3, n);
    }

    private static String replace(String target, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String init(double pow) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pow; i++) {
            sb.append("---");
        }
        return sb.toString();
    }
}




