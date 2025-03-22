import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int[] answer = isPalindrome(s);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }

    private static int[] isPalindrome(String s) {
        return recurtions(s, 0 , s.length() - 1, 1);
    }

    private static int[] recurtions(String s, int l, int r, int count) {
        if (l >= r){
            return new int[]{1, count};
        }
        if(s.charAt(l) != s.charAt(r)){
            return new int[]{0, count};
        }
        return recurtions(s, ++l, --r, ++count);
    }
}




