import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

//Реализовать простой калькулятор
public class task1_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение, которое хотите вычислить, с пробелами: ");
        String expression = scan.nextLine();
        scan.close();
        String[] components = expression.split(" ");
        int firstNumber = Integer.parseInt(components[0]);
        int secondNumber = Integer.parseInt(components[2]);
        if (Objects.equals(components[1], "+")) {
            int sum = firstNumber + secondNumber;
            System.out.println(sum);
        } else if (Objects.equals(components[1], "-")) {
            int dif = firstNumber - secondNumber;
            System.out.println(dif);
        } else if (Objects.equals(components[1], "*")) {
            int mult = firstNumber * secondNumber;
            System.out.println(mult);
        } else if (Objects.equals(components[1], "/")) {
            int div = firstNumber / secondNumber;
            System.out.println(div);
        }

    }
}