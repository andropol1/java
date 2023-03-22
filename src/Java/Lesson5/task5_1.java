package Java.Lesson5;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class task5_1 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        while(true) {
            System.out.println("Если хотите добавить данные в телефонную книгу, введите '1'. Иначе введите любую другую цифру.");
            int init = scan.nextInt();
            if (init == 1) {
                addLine(phoneBook);
            } else {
                break;
            }
        }
        printBook(phoneBook);
        scan.close();
    }

    public static void addLine(Map<String, ArrayList<Integer>> phonebook) {
        System.out.println("Введите имя: ");
        scan.nextLine();
        String name = scan.nextLine();
        ArrayList<Integer> arrNums = new ArrayList<>();
        addNumber(arrNums);
        phonebook.put(name, arrNums);
    }

    public static ArrayList<Integer> addNumber(ArrayList<Integer> arrNums) {
        System.out.println("Введите номер телефона, начиная с 8. Например: 89041235577");
        arrNums.add(scan.nextInt());
        System.out.println("Если хотите добавить еще номер, введите '1'. Иначе введите любую другую цифру.");
        int init = scan.nextInt();
        if (init == 1) {
            addNumber(arrNums);
        }
        return arrNums;
    }

    public static void printBook(Map<String, ArrayList<Integer>> phonebook) {
        for (var item : phonebook.entrySet()) {
            String phones = "";
            for (int el : item.getValue()) {
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
}

