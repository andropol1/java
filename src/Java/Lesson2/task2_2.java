package Java.Lesson2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
//2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
public class task2_2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger( task2_2.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int [] arr = {12, 1, 15, 2, 4, 7};

        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;

                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    logger.log(Level.INFO, "Замена местами: " + arr[i] + " и " + arr[i+1]);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
