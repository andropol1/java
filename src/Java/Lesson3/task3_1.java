package Java.Lesson3;
import java.util.Arrays;
public class task3_1 {

//Реализовать алгоритм сортировки слиянием

    public static void main(String[] args) {
        int[] array = {2, 1, 8, 4, 3};
        System.out.println(Arrays.toString(mergeSoft(array)));
    }

    public static int[] mergeSoft(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, left.length, arr.length);
        return merge(mergeSoft(left), mergeSoft(right));

    }

    public static int[] merge(int[] left, int[] right) {
        int resultIndex = 0, leftIndex = 0, rightIndex = 0;
        int[] result = new int[left.length + right.length];

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (resultIndex < result.length) {
            if (leftIndex != left.length) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        return result;
    }
}
