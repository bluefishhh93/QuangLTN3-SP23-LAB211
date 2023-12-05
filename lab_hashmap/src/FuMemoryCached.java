
import java.util.Date;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class FuMemoryCached {
    static HashMap cached =new HashMap<String,FuCached>();

    public FuMemoryCached() { 
    }
    
    public static boolean putObject(String key, Object object, int timeToLive){
        if (cached.containsKey(key)) {
            return false;
        }
        cached.put(key, new FuCached(object, timeToLive));
        return true;
    }
    
    public static Object getObject(String key) {
        
        if (!cached.containsKey(key)) {
            return null;
        }
        FuCached fc = (FuCached) cached.get(key);
        if (fc.getExpriredDate().getTime() < new Date().getTime()) {
            {cached.remove(key);
            return null;}
        }
        return fc.getData();
    }
    public static boolean clean(String key){
        if (!cached.containsKey(key)) {
            return false;
        }
        cached.remove(key);
        return true;
    }
    
    public static boolean  cleanAll(){
        cached.clear();
        return true;
    }
}
