import java.util.*;

public class multilevel {

    LinkedHashMap<String,String> L1=
            new LinkedHashMap<>(10,0.75f,true);

    HashMap<String,String> L2=new HashMap<>();

    public String getVideo(String id){

        if(L1.containsKey(id))
            return "L1 HIT";

        if(L2.containsKey(id)){

            L1.put(id,L2.get(id));
            return "L2 HIT -> promoted";
        }

        String v="VideoFromDB";

        L2.put(id,v);

        return "L3 HIT";
    }

    public static void main(String[] args){

        multilevel m=new multilevel();

        System.out.println(m.getVideo("video1"));
        System.out.println(m.getVideo("video1"));
    }
}