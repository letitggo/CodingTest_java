import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;

    static int startTeamMember;
    static int linkTeamMember;
    static int startTeamMemberScore = 0;
    static int linkTeamMemberScore = 0;
    static int[] startTeamMatch;
    static int[] linkTeamMatch;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        startTeamMatch = new int[n];
        linkTeamMatch = new int[n];
        for (int i = 0; i < n; i++) {
            startTeamMatch[i] = -1;
            linkTeamMatch[i] = -1;
        }

        startTeamMember = 0;
        linkTeamMember = 0;

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startTeam(0);
        System.out.println(min);
    }

    private static void startTeam(int depth) {
        if (startTeamMember >= n/2) {
            return;
        }

        for (int i = depth; i < n; i++) {
            if (startTeamMatch[i] == -1){
                startTeamMatch[i] = i;
                startTeamMember++;

                if (startTeamMember == n/2){
                    calculateStartScore();
                    linkTeam(0);
                    if(min == 0) return;
                }

                startTeam(i);
                startTeamMatch[i] = -1;
                startTeamMember--;
                startTeamMemberScore = 0;

            }
        }
    }

    private static void linkTeam(int depth) {
        if (linkTeamMember >= n/2) {
            return;
        }

        for (int i = depth; i < n; i++) {
            if (linkTeamMatch[i] == -1 && startTeamMatch[i] == -1){
                linkTeamMatch[i] = i;
                linkTeamMember++;

                if (linkTeamMember == n/2){
                    calculateLinkScore();
                    min = Math.min(min, Math.abs(startTeamMemberScore - linkTeamMemberScore));
                    if(min == 0) return;
                }

                linkTeam(i);
                linkTeamMatch[i] = -1;
                linkTeamMember--;
                linkTeamMemberScore = 0;
            }
        }
    }

    private static void calculateStartScore() {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (startTeamMatch[i] != -1 && startTeamMatch[j] != -1)
                    startTeamMemberScore += arr[startTeamMatch[i]][startTeamMatch[j]] + arr[startTeamMatch[j]][startTeamMatch[i]];
            }
        }
    }

    private static void calculateLinkScore() {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (linkTeamMatch[i] != -1 && linkTeamMatch[j] != -1)
                    linkTeamMemberScore += arr[linkTeamMatch[i]][linkTeamMatch[j]] + arr[linkTeamMatch[j]][linkTeamMatch[i]];
            }
        }
    }
}




