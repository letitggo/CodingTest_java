import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer sb;
        int[] nums = new int[2];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            sb = new StringBuffer(s[i]);
            nums[i] = Integer.parseInt(String.valueOf(sb.reverse()));
        }

        bw.write(Math.max(nums[0], nums[1]) + "\n");

        br.close();
        bw.close();
    }
}