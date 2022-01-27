import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap
import java.util.Map

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
    
    public static int[] simplifyRad(int n){
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
        int[] fNumbers = new int[2];
        
        numbers.add(new ArrayList<Integer>());
        numbers.add(new ArrayList<Integer>());
        fNumbers[0] = 1;
        fNumbers[1] = 1;
        
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
        }finally{
            for(int i = 0; i < numbers.get(0).size(); i++){
                fNumbers[0] = fNumbers[0] *numbers.get(0).get(i);
            }
            for(int i = 0; i < numbers.get(1).size(); i++){
                fNumbers[1] = fNumbers[1] * numbers.get(1).get(i);
            }
            return fNumbers;
        }
    }
    
    public static Map twoPoints(int x1, int y1, int x2, int y2){
        
    }
}
