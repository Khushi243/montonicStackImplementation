import java.util.Arrays;
import java.util.Stack;
public class StackNGE {
    //Brute force with time complexity O(n^2)
    public static void nextGreaterBrute(int nums[], int n){
        int [] res = new int [n];
        Arrays.fill(res,-1);
        for(int i = 0; i < n; i++ ){
            for(int j = i+1; j< n; j++){
                if(nums[j] > nums[i]){
                    res[i]=nums[j];
                    break;
                }
            }                      
        }
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i] + " ");
        }
    }

    //Optimized solution 
    //using Stack- monotonic decreasing stack time complexity O(2*n)
    //this code is generic and can be easily change into NSE, NGE, Right NSE, Left NSE or Right NGE, Left NGE

    //current code is for right NGE

    public static void nextGreaterElement(int nums[]){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int [nums.length];
        Arrays.fill(res,-1);

        //for Left Nge/NSE change the direction of for loop 
        for(int i = 0 ; i < nums.length ; i++){
            //for NSE change the comparision sign only 
            while( !stack.isEmpty() && nums[stack.peek()] < nums[i] ){
                //pop the peek element
                int popIndex = stack.pop();
                System.out.print("Pop Index " + popIndex + " ");
                res[popIndex] = nums[i];
            }
            stack.push(i);
        }
        for(int i = 0 ; i < res.length ; i++){
            System.out.print(res[i] + " ");
        }
        
    }
    public static void main(String[] args){
        int [] nums={1,5,-1,7};
        int n = nums.length;
        nextGreaterElement(nums);
        System.out.println(" ");
        nextGreaterBrute(nums, n);
    }
}

