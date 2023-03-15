package Java.Lesson3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class task3_2 {
    //Пусть дан произвольный список целых чисел, удалить из него чётные числа

    public static void main(String[] args) {
        ArrayList<Integer> ListOfInt = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
        List<Integer> newListOfInt = new ArrayList<>();
        for (Integer item : ListOfInt) {
            if (item % 2 != 0) {
                newListOfInt.add(item);
            }
        }
        System.out.println("Введеный список: " + ListOfInt +"\n" +
                "Список без четных чисел: " + newListOfInt);
    }
}
