import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String str = br.readLine();
        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if(s.equals("A") || s.equals("B") || s.equals("C")) {
                total += 3;
            } else if(s.equals("D") || s.equals("E") || s.equals("F")) {
                total += 4;
            }else if (s.equals("G") || s.equals("H") || s.equals("I")) {
                total += 5;
            }else if (s.equals("J") || s.equals("K") || s.equals("L")) {
                total += 6;
            }else if (s.equals("M") || s.equals("N") || s.equals("O")) {
                total += 7;
            }else if (s.equals("P") || s.equals("Q") || s.equals("R") || s.equals("S")) {
                total += 8;
            }else if (s.equals("T") || s.equals("U") || s.equals("V")) {
                total += 9;
            }else if (s.equals("W") || s.equals("X") || s.equals("Y") || s.equals("Z")) {
                total += 10;
            }
        }
        bw.write(total + "\n");
        br.close();
        bw.close();
    }
}