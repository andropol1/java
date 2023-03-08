import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task1_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите уравнение вида q + w = e, q, w, e >= 0.  " +
                "Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.");
        String inputString = scan.nextLine();
        scan.close();
        int countOfGaps = 0;
        Integer[] gapPosition = {};
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '?'){
                countOfGaps++;
                gapPosition = append(gapPosition, i);
            }
        }

        for (int nums = 0; nums < Math.pow(10, countOfGaps); nums++) {
            for (int i = 0; i <= 1; i++) {
                inputString = replaceGapPosition(inputString, gapPosition[i], nums % 10);
            }
            checkResult(inputString);
        }
        System.out.println("Решения нет");
    }

    public static String replaceGapPosition(String inputString, int index, int newValue){
        char[] chars = inputString.toCharArray();
        chars[index] = (char)('0' + newValue);
        return String.valueOf(chars);
    }

    public static void checkResult(String stringToCheck){
        String[] variables = stringToCheck.split(" ");
        if (Integer.parseInt(variables[0]) + Integer.parseInt(variables[2]) == Integer.parseInt(variables[4])){
            System.out.println(variables[0] + " + " + variables[2] + " = " + variables[4]);
            System.exit(0);
        }
    }

    public static Integer[] append(Integer[] arr, int element){
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        list.add(element);

        return list.toArray(new Integer[0]);
    }
}
