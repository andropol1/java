package Java.Lesson6;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Task6_1 {
    public static void main(String[] args) {
        HashSet<Notebook> notes = new HashSet<>();
        Notebook firstNote = new Notebook("MSI", "Thunderbolt", 8, 512);
        Notebook secondNote = new Notebook("HP", "123", 4, 256);
        Notebook thirdNote = new Notebook("Samsung", "SG", 16, 1024);
        Notebook forthNote = new Notebook("Samsung", "SGI", 16, 512);
        Notebook fifthNote = new Notebook("MSI", "Thunderbolt", 32, 1024);
        Collections.addAll(notes, firstNote, secondNote, thirdNote, forthNote, fifthNote);
        System.out.println("Критерии поиска:\n1 - бренд, \n2 - модель, \n3 - ОЗУ, \n4: объем ЖД");
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        for (String element: input) {
            try {
                switch (element) {
                    case "1":
                        System.out.print("Выберите бренд (MSI, HP, Samsung и т.д.): ");
                        String str1 = scan.next();
                        brandSort(notes, str1);
                        for (Notebook el:
                                notes) {
                            System.out.println(el);
                        }
                        break;
                    case "2":
                        System.out.println("Выберите модель (Thunderbolt, 123, SG и т.д.: ");
                        String str2 = scan.next();
                        modelSort(notes, str2);
                        for (Notebook el:
                                notes) {
                            System.out.println(el);
                        }
                        break;
                    case "3":
                        System.out.println("Выберите объем ОЗУ (4, 8, 16 и т.д.): ");
                        int num1 = scan.nextInt();
                        ramSort(notes, num1);
                        for (Notebook el:
                                notes) {
                            System.out.println(el);
                        }
                        break;
                    case "4":
                        System.out.println("Выберите объем жесткого диска (128, 256, 512 и т.д.): ");
                        int num2 = scan.nextInt();
                        memorySort(notes, num2);
                        for (Notebook el:
                                notes) {
                            System.out.println(el);
                        }
                        break;
                    default:
                        throw new IOException();
                }
            }catch (IOException e){
                System.out.println("Неверный ввод!");
            }
        }

    }

    public static void brandSort(HashSet<Notebook> notes, String str){
        notes.removeIf(item -> !str.equals(item.getBrand()));
    }
    public  static void modelSort(HashSet<Notebook> notes, String str){
        notes.removeIf(item -> !str.equals(item.getModel()));
    }
    public static void ramSort(HashSet<Notebook> notes, int num){
        notes.removeIf(item -> num != item.getRam());
    }
    public static void memorySort(HashSet<Notebook> notes, int num){
        notes.removeIf(item -> num != item.getMemory());
    }
}
