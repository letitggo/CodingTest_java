import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] list = new int[100];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            list[i] = scan.nextInt();
        }
        int target = scan.nextInt();

        for (int i = 0; i < n; i++) {
            if (target == list[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
