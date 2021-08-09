package CreateSetWithoutDuplicate;

import java.util.*;

public class MainCreateSetWithoutDuplicate {
    public static void main(String[] args) {
      //first task "create list integer without duplicate"
      List<Integer> rundomList=new ArrayList<>();
        Random random=new Random();
        for (int i=0;i<100;i++){
            rundomList.add(random.nextInt(20));
        }
        System.out.println(rundomList);
        Long now=System.currentTimeMillis();
        Set<Integer> set = new HashSet<>(rundomList);
        System.out.println(set);
        for (Integer uniqueValue : set) {
            long occurences = finedOccurance(uniqueValue,rundomList);
            //long occurences = rundomList.stream().filter(x -> x == uniqueValue).count();
            if(occurences > 1) {
                System.out.println("number "+uniqueValue + " occurence " + occurences +"times");
            }
        }
        System.out.println("time is "+ (System.currentTimeMillis()-now)+"ms");
    }
    private static long finedOccurance (int number,List<Integer> list){
        long numberOfOccurance=0;
        for (int element :list) {
            if (element==number){
                numberOfOccurance++;
            }
        }
        return numberOfOccurance;
    }
}
