import java.util.*;

public class web_traffic {

    HashMap<String,Integer> pageViews=new HashMap<>();
    HashMap<String,Set<String>> visitors=new HashMap<>();
    HashMap<String,Integer> source=new HashMap<>();

    public void process(String url,String user,String src){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);

        source.put(src,source.getOrDefault(src,0)+1);
    }

    public void showStats(){

        System.out.println(pageViews);
        System.out.println(source);
    }

    public static void main(String[] args){

        web_traffic w=new web_traffic();

        w.process("/news","u1","google");
        w.process("/news","u2","facebook");

        w.showStats();
    }
}