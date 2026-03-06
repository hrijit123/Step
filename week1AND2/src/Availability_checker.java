import java.util.*;

public class Availability_checker {

    private HashMap<String,Integer> users = new HashMap<>();
    private HashMap<String,Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username){

        attempts.put(username, attempts.getOrDefault(username,0)+1);

        return !users.containsKey(username);
    }

    public void registerUser(String username,int id){
        users.put(username,id);
    }

    public List<String> suggestAlternatives(String username){

        List<String> list = new ArrayList<>();

        list.add(username+"1");
        list.add(username+"2");
        list.add(username.replace("_","."));

        return list;
    }

    public String getMostAttempted(){

        String best="";
        int max=0;

        for(String u:attempts.keySet()){

            if(attempts.get(u)>max){
                max=attempts.get(u);
                best=u;
            }
        }

        return best;
    }

    public static void main(String[] args){

        Availability_checker a = new Availability_checker();

        a.registerUser("john_doe",1);

        System.out.println(a.checkAvailability("john_doe"));
        System.out.println(a.checkAvailability("jane_smith"));
        System.out.println(a.suggestAlternatives("john_doe"));
    }
}