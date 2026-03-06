import java.util.*;

public class search_engine {

    HashMap<String,Integer> freq=new HashMap<>();

    public void addQuery(String q){

        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    public void search(String prefix){

        for(String q:freq.keySet())
            if(q.startsWith(prefix))
                System.out.println(q+" "+freq.get(q));
    }

    public static void main(String[] args){

        search_engine s=new search_engine();

        s.addQuery("java tutorial");
        s.addQuery("javascript");

        s.search("jav");
    }
}