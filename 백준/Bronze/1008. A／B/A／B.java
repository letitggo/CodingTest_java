import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();
        double answer = 0;
        answer = (double) a /b;
        System.out.println(answer);
    }
}