
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        double[] grade = new double[n];
        double answer = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            grade[i] = Double.parseDouble(st.nextToken());
        }

        double max = grade[0];

        for (int i = 0; i < n; i++) {
            if (max < grade[i])
                max = grade[i];
        }

        for (int i = 0; i < n; i++) {
            grade[i] = grade[i]/max * 100;
            answer += grade[i];
        }

        answer = answer / n;

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }
}
