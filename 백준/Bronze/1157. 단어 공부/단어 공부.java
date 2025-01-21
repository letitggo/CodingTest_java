import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] list = new int[26];

        String str = br.readLine().trim().toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {}
            list[str.charAt(i) - 'A']++;
        }

        int max = -1;
        char ch = '?';

        for(int i = 0; i < 26; i++) {
            if(list[i] > max){
                max = list[i];
                ch = (char) (i + 65);
            }else if (list[i] == max) {
                ch = '?';
            }
        }

        bw.write(ch);

        br.close();
        bw.close();
    }
}