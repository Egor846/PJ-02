import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public Object randomMonster(){

    List<Object> monsters = new ArrayList<>();
    monsters.add(goblin);
    monsters.add(skeleton);
    Random random = new Random();
    return monsters.get(random.nextInt(0,2));



}