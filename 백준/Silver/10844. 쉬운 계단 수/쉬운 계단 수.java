import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static long[][] p; //p[a][0],p[a][1] 각각 길이 a계단만드는데 마지막이 0,1인 갯수
    //나머지 2부터 9까지도 마찬가지
    static int MOD = 1_000_000_000;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        p = new long[N+1][10];

        bw.write(String.valueOf(stairs(N)));
        bw.flush();
        bw.close();

    }

    public static long stairs(int n) {
        p[1][0] = 0;
        p[1][1] = 1;
        p[1][2] = 1;
        p[1][3] = 1;
        p[1][4] = 1;
        p[1][5] = 1;
        p[1][6] = 1;
        p[1][7] = 1;
        p[1][8] = 1;
        p[1][9] = 1;

        for(int i = 2 ; i < n+1 ; i++) {
            p[i][0] = p[i-1][1] % MOD; 
            p[i][1] = (p[i-1][0] + p[i-1][2]) % MOD;
            p[i][2] = (p[i-1][1] + p[i-1][3]) % MOD;
            p[i][3] = (p[i-1][2] + p[i-1][4]) % MOD;
            p[i][4] = (p[i-1][3] + p[i-1][5]) % MOD;
            p[i][5] = (p[i-1][4] + p[i-1][6]) % MOD;
            p[i][6] = (p[i-1][5] + p[i-1][7]) % MOD;
            p[i][7] = (p[i-1][6] + p[i-1][8]) % MOD;
            p[i][8] = (p[i-1][7] + p[i-1][9]) % MOD;
            p[i][9] = p[i-1][8] % MOD; 
        }
        return (p[n][0] + p[n][1] + p[n][2] + p[n][3] + p[n][4] + p[n][5] + p[n][6] + p[n][7] + p[n][8] + p[n][9]) % MOD;

    }
}