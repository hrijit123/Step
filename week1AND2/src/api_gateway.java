import java.util.*;

public class api_gateway {

    static class Bucket{

        int tokens=1000;
    }

    HashMap<String,Bucket> clients=new HashMap<>();

    public boolean check(String id){

        clients.putIfAbsent(id,new Bucket());

        Bucket b=clients.get(id);

        if(b.tokens>0){

            b.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        api_gateway a=new api_gateway();

        System.out.println(a.check("client1"));
    }
}