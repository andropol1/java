package Java.Lesson4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//Реализуйте очередь с помощью LinkedList со следующими методами:
//        • enqueue() — помещает элемент в конец очереди,
//        • dequeue() — возвращает первый элемент из очереди и удаляет его,
//        • first() — возвращает первый элемент из очереди, не удаляя.
public class task4_2 {
    public static void main(String[] args) {
        LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Изначальный массив: " + numList);
        System.out.println(enqueue(numList));
        System.out.println("Первый элемент массива: " + dequeue(numList) + "\nИзмененный массив: " + numList);
        System.out.println("Первый элемент массива: " + first(numList) + "\nМассив никак не изменился.");
    }

    public static LinkedList<Integer> enqueue(LinkedList<Integer> numList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите элемент,который хотите добавить:");
        int element = scan.nextInt();
        numList.add(element);
        System.out.println("Измененный массив: ");
        return numList;
    }

    public static int dequeue(LinkedList<Integer> numList){
        return numList.removeFirst();
    }

    public static int first(LinkedList<Integer> numList){
        return numList.getFirst();
    }
}
