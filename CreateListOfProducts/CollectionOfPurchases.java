package CreateListOfProducts;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class CollectionOfPurchases {
    public static void main(String[] args) {
        HashMap<String,Integer> listOfPurchases=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Random random=new Random();
            int quantity=random.nextInt(100);
            listOfPurchases.put("product" + i+1, quantity);
        }
        System.out.println("List of products: " + listOfPurchases);
        Collection<Integer> values = listOfPurchases.values();
        System.out.println("count of products is "+getSum(values));
    }
    public static int getSum(Collection<Integer> values){
        int sum=0;
        for (int value : values) {
            sum+= value;
        }
        return sum;
    }
}
