//Вычислить [n-ое треугольного число](сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class task1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число n: ");
        Integer n = scan.nextInt();
        scan.close();
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            factorial *= i;
        }
        System.out.printf("N-ое треугольное число равно %d, факториал числа равен %d", sum, factorial);

    }
}
