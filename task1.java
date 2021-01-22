import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        //Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        changeElementsAndShow(list, 1, 2);
        List<String> list2 = Arrays.asList("a", "b", "c", "d", "e");
        changeElementsAndShow(list2, 1, 2);

        System.out.println("Задание 2");
        //Написать метод, который преобразует массив в ArrayList;
        Integer[] arr = {1, 2, 3, 4, 5};
        //changeMassToArr(arr);
        if (changeMassToArr(arr) instanceof ArrayList) {
            System.out.println("Its List");
        } else {
            System.out.println("error");

        }

        System.out.println("Задание 3");
        //Большая задача
        Box<Apple> appleBox = new Box(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox = new Box(new Orange());
        Box<Orange> orangeBox2 = new Box();

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        orangeBox.transferFruitsToAnotherBox(orangeBox2);
    }

    public static <T> List<T> changeElementsAndShow(List<T> list, int i, int j) {
        List<T>list2 = list;
        T d = list2.get(i);
        list2.set(i, list2.get(j));
        list2.set(j, d);
        for (T s : list) {
            System.out.print(s);
        }
        System.out.println();
        return list2;

    }

    public static <T> List<T> changeMassToArr(T[] arr){
        List<T> list3 = new ArrayList(Arrays.asList(arr));
        return list3;

    }
}

