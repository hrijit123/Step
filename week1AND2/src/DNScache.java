import java.util.*;

public class DNScache {

    static class Entry{

        String ip;
        long expiry;

        Entry(String ip,long ttl){

            this.ip=ip;
            this.expiry=System.currentTimeMillis()+ttl;
        }

        boolean expired(){
            return System.currentTimeMillis()>expiry;
        }
    }

    HashMap<String,Entry> cache = new HashMap<>();

    public String resolve(String domain){

        if(cache.containsKey(domain)){

            Entry e = cache.get(domain);

            if(!e.expired()){
                return "Cache HIT "+e.ip;
            }
        }

        String ip="192.168.1."+new Random().nextInt(255);

        cache.put(domain,new Entry(ip,5000));

        return "Cache MISS "+ip;
    }

    public static void main(String[] args){

        DNSCache d = new DNSCache();

        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
    }
}