package juliaiskra;

/**
 * @author Julia Nemtseva
 */
public class Sorter {
    public static void sort(int[] array) {
        if (array.length < 2) return;

        for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            final int current = array[currentIndex];

            if (current <= array[0]) {
                putInTheBeginning(array, currentIndex);
                continue;
            }

            final int biggerThanCurrentIndex = getFirstBiggerElementIndex(array, current);
            if (biggerThanCurrentIndex < currentIndex && biggerThanCurrentIndex < array.length) {
                putAfter(array, biggerThanCurrentIndex - 1);
            }
        }
    }

    private static int getFirstBiggerElementIndex(int[] array, int compareTo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > compareTo) return i;
        }

        return array.length;
    }

    public static void sortFromInterview(int[] array) {
        if (array.length < 2) return;
        if (array[1] < array[0]) {
            reverse(array, 2);
        }

        for (int compareIndex = 2; compareIndex < array.length; compareIndex++) {
            final int minSorted = array[0];
            final int maxSorted = array[compareIndex - 1];
            final int current = array[compareIndex];

            if (current <= minSorted) {
                putInTheBeginning(array);
            } else if (minSorted < current && current < maxSorted) {
                putAfter(array, compareIndex - 1);
            } else if (current >= maxSorted) {
                continue;
            }
        }
    }

    private static void putInTheBeginning(int[] array, int index) {
        reverse(array, index);
        reverse(array, index + 1);
    }

    private static void putInTheBeginning(int[] array) {
        putInTheBeginning(array, array.length - 1);
    }

    private static void putAfter(int[] array, int index) {
        reverse(array, index + 1);
        reverse(array, array.length - 1);
        reverse(array, array.length);
        reverse(array, index + 2);
    }

    /**
     * Reverses first N elements in an array
     *
     * @param array array to modify
     * @param numberToReverse number of elements to reverse (N)
     */
    public static void reverse(int[] array, int numberToReverse) {
        if (numberToReverse < 2 || array.length < 2) return;
        int buffer;
        for (int index = 0; index < numberToReverse / 2; index++) {
            buffer = array[index];
            array[index] = array[numberToReverse - 1 - index];
            array[numberToReverse - 1 - index] = buffer;
        }
    }
}
