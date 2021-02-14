package org.example;

public class Task6 {
    public static int[] LastFour(int[] arr) throws RuntimeException {
        int[] result=null;
        for (int i = arr.length-1; i > 0 ; i--) {
            if (arr[i]==(4)) {
                result =  new int[arr.length-i-1];
                System.arraycopy(arr, i+1, result, 0, arr.length-i-1);
                break;
            }
        }

        if (result==null) {System.err.println("В исходном массиве нет четверок");
            throw new RuntimeException();
        }

        return result;
    }

    public static boolean checkArr(int[] arr) {
        boolean one = false;
        boolean four = false;

        for (int i = 0; i < arr.length; i++) {
            if (one & four) break;
            if (arr[i] == 1) one = true;
            if (arr[i] == 4) four = true;
        }

        return (one && four);
    }
}
