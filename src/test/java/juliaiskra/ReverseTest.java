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
public class ReverseTest {
    private int[] array;
    private int number;
    private int[] reversedArray;

    public ReverseTest(int[] array, int number, int[] reversedArray) {
        this.array = array;
        this.number = number;
        this.reversedArray = reversedArray;
    }


    @Parameterized.Parameters
    public static Collection dataProvider() {
            return Arrays.asList(new Object[][] {
                    {
                            new int[]{},
                            5,
                            new int[]{}
                    },
                    {
                            new int[]{1},
                            1,
                            new int[]{1}
                    },
                    {
                            new int[]{1, 2},
                            2,
                            new int[]{2, 1}
                    },
                    {
                            new int[]{1, 2},
                            1,
                            new int[]{1, 2},
                    },
                    {
                            new int[]{3, 1, 2},
                            2,
                            new int[]{1, 3, 2}
                    },
                    {
                            new int[]{3, 1, 2},
                            3,
                            new int[]{2, 1, 3}
                    },
            });
    }

    @Test
    public void testReverse() {
        System.out.format("Reverse an array: %s for %s elements", Arrays.toString(array), number);
        Sorter.reverse(array, number);
        Assert.assertArrayEquals(reversedArray, array);
    }
}
