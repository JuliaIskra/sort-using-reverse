package juliaiskra;

/**
 * @author Julia Nemtseva
 */
public class Sorter {
    public static void sort(int[] array) {
        if (array.length < 2) return;

        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            final int maxIndex = findMaxElementIndex(array, currentIndex);
            putInTheBeginning(array, maxIndex);
        }
    }

    /**
     * Finds maximum element in an array starting from specified index and returns its index
     *
     * @param array array to search
     * @param startFrom index to start search from
     * @return index of maximum element
     */
    private static int findMaxElementIndex(int[] array, int startFrom) {
        int max = array[startFrom];
        int maxIndex = startFrom;
        for (int i = startFrom + 1; i < array.length; i++) {
            int current = array[i];
            if (current > max) {
                max = current;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    private static void putInTheBeginning(int[] array, int index) {
        reverse(array, index);
        reverse(array, index + 1);
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
