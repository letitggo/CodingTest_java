import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour, min;
        int cookingTime;
        hour = sc.nextInt();
        min = sc.nextInt();
        cookingTime = sc.nextInt();

        min += cookingTime;

        hour = (hour + min/60) % 24;
        min = min%60;

        System.out.println(hour + " " + min);
    }
}
