import java.util.Stack;

public class Solution503 {

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            res[i%n] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1};
        int[] b = nextGreaterElements(a);
        for(int c : b){
            System.out.println(c);
        }
    }
}
