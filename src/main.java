import java.util.Arrays;
import java.util.Random;


public class main {

    public static void main(String[] args) {

        Random random = new Random();

        int [] array = new int[10];

        array[0] = 5;
        array[1] = 2;
        array[2] = 1;
        array[3] = 8;
        array[4] = 3;
        array[5] = 4;
        array[6] = 6;
        array[7] = 7;
        array[8] = 0;
        array[9] = 9;

        int[] sortedArray = mergeSort(array);

        printArray(sortedArray, "final");
    }

    public static int[] mergeSort(int[] array) {

        if(array.length < 2)
            return array;

        int middle = array.length / 2;

        int[] leftArray = Arrays.copyOfRange(array, 0, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, array.length);

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        return merge(leftArray, rightArray);
    }

    public static void printArray(int[] array, String pre) {
        for(int x: array) {
            System.out.println(pre + ":" + x);
        }
    }

    public static int [] merge(int[] arrayLeft, int[] arrayRight) {

        int sizeLeft = arrayLeft.length;
        int sizeRight = arrayRight.length;
        int sizeMax = sizeLeft + sizeRight;
        int i = 0, j = 0, k = 0;

        int[] sortedArray = new int[sizeMax];

        while(i < sizeLeft && j < sizeRight) {

            if (arrayLeft[i] <= arrayRight[j]) {
                sortedArray[k] = arrayLeft[i];
                i++;
            } else {
                sortedArray[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        while(i < sizeLeft) {
            sortedArray[k] = arrayLeft[i];
            k++;
            i++;
        }

        while(j < sizeRight) {
            sortedArray[k] = arrayRight[j];
            k++;
            j++;
        }

        return sortedArray;
    }
}
