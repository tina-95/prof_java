import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box  <T extends Fruit> {
    List <T> box;
    private Fruit fruit;


    Box(T... box){
        this.box = new ArrayList<>(Arrays.asList(box));
    }
    
    public float getWeight(){
        float weight=0.0f;
        for (T fruit : box ) weight+=fruit.getWeight();
            return weight;
        }


    public boolean compare (Box secondBox){
        return Math.abs(this.getWeight()-secondBox.getWeight())<0.01;
    }

    public void transferFruitsToAnotherBox(List<T>secondBox) {
        if(secondBox == this) {
            System.out.println("та же коробка");

        } else{
            this.box.addAll(secondBox);
            secondBox.clear();
        }

    }

    public void addFruit(T fruit){
            box.add(fruit);
        }

    }

