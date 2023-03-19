package Java.Lesson4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//В калькулятор добавьте возможность отменить последнюю операцию.
public class task4_3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(task4_3.class.getName());
        log.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("calc_log.txt");
        log.addHandler(fh);
        log.setUseParentHandlers(false);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите кол-во чисел, с которыми хотите совершить математические операции: ");
        int countNums = scan.nextInt();
        List<Integer> arrNums = new ArrayList<>();
        List<Character> arrOps = new ArrayList<>();
        for (int i = 0; i < countNums; i++) {
            arrNums.add(getInt(i+1, log));
            if (i < countNums - 1){
                arrOps.add(getOperation(i+1, log));
            }
        }
        int result = arrNums.get(0);
        List<Integer> arrRes = new ArrayList<>();
        for (int i = 0; i < countNums-1; i++) {
            result = calc(result, arrNums.get(i+1), arrOps.get(i));
            arrRes.add(result);
        }
        System.out.println("Результат операции: " + result);
        log.info("Получения результата вычисления.");
        int cancelCheck = 0;
        System.out.println("Если хотите отменить последнюю операцию, введите '1'. Иначе введите что угодно.");
        if (scanner.hasNextInt()){
            cancelCheck = scanner.nextInt();
        } else{
            System.out.println("Работа программы завершена. Если хотите снова ей воспользоваться, перезапустите ее.");
        }
        if (cancelCheck == 1){
            if (arrRes.size() > 1) {
                System.out.println("Последняя операция отменена, новый результат: " + arrRes.get(arrRes.size() - 2));
            }else{
                System.out.println("Вы отменили единственную операцию.");
            }
        }
        scanner.close();
    }

    public static int getInt(int index, Logger log){
        System.out.println("Введите " + index + " число:");
        log.info("Ввод числа.");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            log.info("Ошибка при вводе.");
            scanner.next();
            num = getInt(index, log);
        }
        return num;
    }

    public static char getOperation(int index, Logger log){
        System.out.println("Введите " + index + " операцию:");
        log.info("Выбор математической операции.");
        char operation;
        operation = scanner.next().charAt(0);
        if (operation != '+' && operation != '-'&& operation != '*'&& operation != '/'){
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            log.info("Ошибка при вводе.");
            operation = getOperation(index, log);
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result = 0;
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
        }
        return result;
    }
}
