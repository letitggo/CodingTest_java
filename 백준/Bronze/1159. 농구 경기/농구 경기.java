import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int num = name.charAt(0) - 'a';
            arr[num]++;
        }

        boolean can = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5){
                can = true;
                char c = (char) ('a' + i);
                System.out.print(c);
            }
        }
        if (!can) System.out.println("PREDAJA");
    }
}