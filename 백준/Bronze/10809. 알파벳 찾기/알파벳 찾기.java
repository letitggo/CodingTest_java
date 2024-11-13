import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            answer[s.charAt(i) - 'a'] = s.indexOf(String.valueOf(s.charAt(i)));
        }

        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + " ");
        }

        br.close();
        bw.close();
    }
}
