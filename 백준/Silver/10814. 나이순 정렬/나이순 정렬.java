import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[][] matrix = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = st.nextToken();
            matrix[i][1] = st.nextToken();
        }

        // 객체 배열은 안정 정렬(Stable Sort)을 보장한다.
        // 안정 정렬이란 동일한 키값을 가진 요소들의 원본 순서를 유지하는 것
        //  1차 기준: 나이 비교 (s1[0] - s2[0])
        //  2차 기준: 원본 배열의 입력 순서 (코드에 명시되지 않지만 stable sort 덕분에 보장됨)
        Arrays.sort(matrix, (s1, s2) -> {
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][0] + " ");
            System.out.println(matrix[i][1]);
        }

        br.close();
        bw.close();
    }

}
