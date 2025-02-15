import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int answer;

        answer = a == b ? b == c ? 10000 + a * 1000 : 1000 + a * 100 : a == c ? 1000 + a * 100 : b == c ? 1000 + b * 100 : Math.max(Math.max(a, b), c)*100;

        System.out.println(answer);
    }
}