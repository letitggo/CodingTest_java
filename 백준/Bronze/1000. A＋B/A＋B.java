import java.util.Scanner;
class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        int answer = -1;
        a = sc.nextInt();
        b = sc.nextInt();
        answer = a + b;
        System.out.println(answer);
    }
}