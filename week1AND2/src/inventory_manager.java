import java.util.*;

public class inventory_manager {

    private HashMap<String,Integer> stock = new HashMap<>();
    private HashMap<String,Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String product,int qty){

        stock.put(product,qty);
        waiting.put(product,new LinkedList<>());
    }

    public synchronized void purchaseItem(String product,int user){

        int s = stock.getOrDefault(product,0);

        if(s>0){

            stock.put(product,s-1);

            System.out.println("Purchase success. Remaining "+(s-1));
        }
        else{

            waiting.get(product).add(user);

            System.out.println("Added to waiting list position "+waiting.get(product).size());
        }
    }

    public void checkStock(String product){

        System.out.println("Stock: "+stock.getOrDefault(product,0));
    }

    public static void main(String[] args){

        inventory_manager i = new inventory_manager();

        i.addProduct("IPHONE15",2);

        i.purchaseItem("IPHONE15",1);
        i.purchaseItem("IPHONE15",2);
        i.purchaseItem("IPHONE15",3);
    }
}