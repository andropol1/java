package Java.Lesson2;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task2_4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(task2_4.class.getName());
        log.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("calc_log.txt");
        log.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int firstNumber = getInt(log);
        int secondNumber = getInt(log);
        char operation = getOperation(log);
        int result = calc(firstNumber, secondNumber,operation, log);
        System.out.println("Результат операции: "+result);
        log.info("Получения результата вычисления.");
        scanner.close();
    }

    public static int getInt(Logger log){
        System.out.println("Введите число:");
        log.info("Ввод числа.");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            log.info("Ошибка при вводе.");
            scanner.next();
            num = getInt(log);
        }
        return num;
    }

    public static char getOperation(Logger log){
        System.out.println("Введите операцию:");
        log.info("Выбор математической операции.");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            log.info("Ошибка при вводе.");
            scanner.next();
            operation = getOperation(log);
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation, Logger log){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation(log), log);
        }
        return result;
    }
}
