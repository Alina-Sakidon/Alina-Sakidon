import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class threeArrayList {
    public static void main(String[] args) {
        HashSet<Integer> rundomSet =new HashSet<Integer>();
        List<Integer> listDivideInto2=new ArrayList<>();
        List<Integer> listDivideInto3=new ArrayList<>();
        List<Integer> listNotDivideInto2and3=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; rundomSet.size()<100; i++){
            rundomSet.add(random.nextInt(500));
        }
        System.out.println("random list is: " + rundomSet);
        for (int value :
                rundomSet) {
            if (value % 2 == 0) {
                listDivideInto2.add(value);
            }
            if (value%3==0){
                listDivideInto3.add(value);
            }
            if (value % 2 !=0 && value % 3 != 0) {
                listNotDivideInto2and3.add(value);
            }
        }
        System.out.println("list div into 2 "+listDivideInto2);
        System.out.println("list div into 3 "+listDivideInto3);
        System.out.println("list not div into 2 and 3 "+listNotDivideInto2and3);
    }
}
