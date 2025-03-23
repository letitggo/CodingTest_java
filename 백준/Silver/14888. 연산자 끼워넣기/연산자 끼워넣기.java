import java.io.*;

public class Main {

    static int[] operator;
    static int[] an;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        operator = new int[4];    // (+ - * /)
        int n = Integer.parseInt(br.readLine());
        an = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            an[i] = Integer.parseInt(split[i]);
        }

        String[] oper = br.readLine().split(" ");
        for (int i = 0; i < oper.length; i++) {
            operator[i] = Integer.parseInt(oper[i]);
        }

        backtrack(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtrack(int depth, long result) {

        int remain = 0;
        for (int i = 0; i < 4; i++) {
            remain += operator[i];
        }
        if (remain == 0 || depth > an.length){
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        long operated;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operator[i]; j++) {
                if (operator[i] != 0) {
                    --operator[i];
                    if (depth == 0){
                        operated = operate(an[depth], an[depth+1], i);
                    }else {
                        operated = operate(result, an[depth+1], i);
                    }
                    backtrack(depth + 1, operated);
                    ++operator[i];
                }
            }
        }
    }

    private static long operate(long n1, long n2, int operator){
        long result = 0;
        switch (operator) {
            case 0: result = n1 + n2; break;
            case 1: result = n1 - n2; break;
            case 2: result = n1 * n2; break;
            case 3: result = n1 / n2; break;
        }
        return result;
    }
}




