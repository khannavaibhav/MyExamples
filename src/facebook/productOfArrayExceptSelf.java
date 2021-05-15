package facebook;

public class productOfArrayExceptSelf {
 public int[] productExceptSelf(int[] nums) {
        int calc = 1;
        int zeroCount = 0;
        int index = 0;
        int[] op = new int[nums.length];
        for(int n:nums){
            if(n == 0){
                zeroCount++;
                op[index] = 0;
            }
            else if(zeroCount < 2){
                calc = calc*n;
                op[index] = 1;
            }
            else{
                 op[index] = 0;
            }
            index ++;
        }        
       
        index = 0;
        for(int n:nums){
            if(zeroCount > 1){
                op[index++] = 0;
            }
            else if(zeroCount == 0){
                op[index++] = calc/n;
            }
            else if(op[index] == 0){
                op[index++] = calc;
            }
            else{
                op[index++] = 0;
            }
            
        }
        return op;
    }
}
