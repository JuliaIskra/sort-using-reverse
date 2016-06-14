package juliaiskra;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Julia Nemtseva
 */
@RunWith(Parameterized.class)
public class SortTest {
    private int[] array;
    private int[] sortedArray;

    public SortTest(int[] array, int[] sortedArray) {
        this.array = array;
        this.sortedArray = sortedArray;
    }


    @Parameterized.Parameters
    public static Collection dataProvider() {
            return Arrays.asList(new Object[][] {
                    {
                            new int[]{},
                            new int[]{}
                    },
                    {
                            new int[]{1},
                            new int[]{1}
                    },
                    {
                            new int[]{1, 2},
                            new int[]{1, 2}
                    },
                    {
                            new int[]{2, 1},
                            new int[]{1, 2},
                    },
                    {
                            new int[]{3, 1, 2},
                            new int[]{1, 2, 3}
                    },
                    {
                            new int[]{1, 2, 3, 5, 6, 7, 4},
                            new int[]{1, 2, 3, 4, 5, 6, 7}
                    },
                    {
                            new int[]{2, 3, 4, 5, 6, 7, 1},
                            new int[]{1, 2, 3, 4, 5, 6, 7}
                    },
                    {
                            new int[]{1, 2, 3, 4, 5, 6, 7},
                            new int[]{1, 2, 3, 4, 5, 6, 7}
                    },
                    {
                            new int[]{2, 3, 4, 8, 9, 7},
                            new int[]{2, 3, 4, 7, 8, 9}
                    }
            });
    }

    @Test
    public void testSorting() {
        System.out.println("Sorting an array: " + Arrays.toString(array));
        Sorter.sort(array);
        Assert.assertArrayEquals(sortedArray, array);
    }
}
