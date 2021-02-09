import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {

        //Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
        //Написать набор тестов для этого метода (по 3-4 варианта входных данных).
        //Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

        Integer[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Integer[] arr2 = {1, 2, 3, 2,4, 2, 3, 5, 1, 7};
        Integer[] arr3 = {4, 4, 4};
        Integer[] arr4 = {1};
        System.out.println("Исходный массив : " + Arrays.asList(arr));
        System.out.println("Обработанный массив : " + Arrays.asList(LastFour(arr)));
        System.out.println("Исходный массив : " + Arrays.asList(arr2));
        System.out.println("Обработанный массив : " + Arrays.asList(LastFour(arr2)));
        System.out.println("Исходный массив : " + Arrays.asList(arr3));
        System.out.println("Обработанный массив : " + Arrays.asList(LastFour(arr3)));
        System.out.println("Исходный массив : " + Arrays.asList(arr4));
       System.out.println("Обработанный массив : " + Arrays.asList(LastFour(arr4)));

        //Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
        //[ 1 1 1 4 4 1 4 4 ] -> true
        //[ 1 1 1 1 1 1 ] -> false
        //[ 4 4 4 4 ] -> false
        //[ 1 4 4 1 1 4 3 ] -> false

        Integer[] arr5 = {1, 4, 1};
        Integer[] arr6 = {4, 4, 4};
        Integer[] arr7 = {15, 6, 9};
        Integer[] arr8 = {0, 4, 1};
        System.out.println("Проверка первого массива : " + Arrays.asList(checkArr(arr5)));
        System.out.println("Проверка второго массива : " + Arrays.asList(checkArr(arr6)));
        System.out.println("Проверка третьего массива : " + Arrays.asList(checkArr(arr7)));
        System.out.println("Проверка четвертого массива : " + Arrays.asList(checkArr(arr8)));

    }

    public static Integer[] LastFour(Integer[] arr) throws RuntimeException {
        Integer[] result=null;
        for (int i = arr.length-1; i > 0 ; i--) {
            if (arr[i].equals(4)) {
                result =  new Integer[arr.length-i-1];
                System.arraycopy(arr, i+1, result, 0, arr.length-i-1);
                break;
            }
        }

        if (result==null) {System.err.println("В исходном массиве нет четверок");
        throw new RuntimeException();
        }

        return result;
    }

    public static boolean checkArr(Integer[] arr) {
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

