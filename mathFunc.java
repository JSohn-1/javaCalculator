import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class mathFunc{
    
    //Basic Methods
    public static boolean isPrime(int n){
        int flag = 0;
          
        if(n > 1){
            for(int i = 2; i < (int) Math.sqrt(n) + 1; i++){
                if(n % i == 0){
                    flag = 1;
                    break;
                }
            }
            
            if(flag == 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    //Advanced Methods
    
    public static String simplifyRad(int n){
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
        
        numbers.add(new ArrayList<Integer>());
        numbers.add(new ArrayList<Integer>());
        
        int total = 1;
        int totalS = 1;
        
        while(true){
            if(isPrime(n)){
                numbers.get(0).add(n);
                break;
            }else{
                for(int i = 1; i < n; i++){
                    if(isPrime(i) && (n % i == 0)){
                        numbers.get(0).add(i);
                        n /= i;
                        break;
                    }
                }
            }
        }
        
        try{
            while(true){
                for(int i = 0; i < numbers.get(0).size(); i++){
                    if(numbers.get(0).get(i) == numbers.get(0).get(i+1)){
                        numbers.get(1).add(numbers.get(0).get(i));
                        numbers.get(0).remove(i);
                        numbers.get(0).remove(i);
                        
                        break;
                    }
                }
            }
        }catch (Exception e){
            int i = 0;
        }
        
        for(int i = 0; i < numbers.get(1).size(); i++){
            total *= numbers.get(1).get(i);
        }
        for(int i = 0; i < numbers.get(0).size(); i++){
            totalS *= numbers.get(0).get(i);
        }
        return("Total is: " + total + " " + totalS);

    }
}
