package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;

class Task6Test {


    @Parameterized.Parameters
    public static List<int[][]> data() {
        return Arrays.asList(new int[][][]{
                {{1, 2, 4, 4, 2, 3, 4, 1, 7}, {1, 7}},
                {{1, 2, 3, 2,4, 2, 3, 5, 1, 7}, {2, 3, 5, 1, 7}},
                {{4, 4, 4}, {}},
                {{4, 1}, {1}},

        });
    }

    private int[] x;
    private int[] result;

    public void LastFour(int[] x, int[] result) {
        this.x = x;
        this.result = result;
    }


    @Before
    public void init() {
        System.out.println("init Task6");
        Task6 task = new Task6();
    }

    @Test
    public void massTestAdd() {
        Assert.assertArrayEquals(result, Task6.LastFour(x));
    }

    @Test
    public void test1() {
        Assert.assertTrue(Task6.checkArr(new int[]{1, 4, 1}));
    }

    @Test
    public void test2() {
        Assert.assertTrue(Task6.checkArr(new int[]{4, 4, 4}));
    }
    @Test
    public void test3() {
        Assert.assertTrue(Task6.checkArr(new int[]{15, 6, 9}));
    }

    @Test
    public void test4() {
        Assert.assertFalse(Task6.checkArr(new int[]{0, 4, 1}));
    }


}