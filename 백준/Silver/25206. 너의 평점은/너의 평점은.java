import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String s;
        // 학점 총합
        double total = 0;
        // 과목 평점
        double grade = 0;

        while ((s = br.readLine()) != null) {
            String[] split = s.split(" ");
            if (split[2].equals("A+")) {
                grade += Double.valueOf(split[1]);
                total += 4.5 * Double.valueOf(split[1]);
            } else if (split[2].equals("A0")) {
                grade += Double.valueOf(split[1]);
                total += 4.0 * Double.valueOf(split[1]);
            } else if (split[2].equals("B+")) {
                grade += Double.valueOf(split[1]);
                total += 3.5 * Double.valueOf(split[1]);
            } else if (split[2].equals("B0")) {
                grade += Double.valueOf(split[1]);
                total += 3.0 * Double.valueOf(split[1]);
            } else if (split[2].equals("C+")) {
                grade += Double.valueOf(split[1]);
                total += 2.5 * Double.valueOf(split[1]);
            } else if (split[2].equals("C0")) {
                grade += Double.valueOf(split[1]);
                total += 2.0 * Double.valueOf(split[1]);
            } else if (split[2].equals("D+")) {
                grade += Double.valueOf(split[1]);
                total += 1.5 * Double.valueOf(split[1]);
            } else if (split[2].equals("D0")) {
                grade += Double.valueOf(split[1]);
                total += 1.0 * Double.valueOf(split[1]);
            } else if (split[2].equals("F")) {
                grade += Double.valueOf(split[1]);
                total += 0.0 * Double.valueOf(split[1]);
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format(total / grade));

        br.close();
        bw.close();

    }
}