package Java.Lesson3;
import java.util.ArrayList;
import java.util.Arrays;
public class task3_3 {

//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11,1,2,5,18,5));
        int max = list.get(0);
        int min = max;
        int sum = 0;
        for (Integer item : list) {
            sum += item;
            if (item > max) {
                max = item;
            } else if (item < min) {
                min = item;
            }
        }
        System.out.println("Максимальное: " + max);
        System.out.println("Минимальное: " + min);
        System.out.println("Среднее арифметическое: " + (double) sum / list.size());
    }
}
