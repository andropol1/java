package Java.Lesson4;

import java.util.Arrays;
import java.util.LinkedList;
//Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.
public class task4_1 {
    public static void main(String[] args) {
        LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(11,1,2,5,18,5));
        System.out.println("Изначальный список: " + numList);
        System.out.println("Перевернутый список: " + reverseList(numList));
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> numList){
        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = numList.size()-1; i >= 0 ; i--) {
            newList.add(numList.get(i));
        }
        return newList;
    }
}
