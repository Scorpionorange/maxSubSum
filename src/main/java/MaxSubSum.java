/**
 * Created by ScorpionOrange on 2017/01/02.
 */
public class MaxSubSum {
    public static void main(String[] args){
        System.out.println("Testing");
    }

    /**
     * Cubic maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum1(int[] a){
        int maxSum = 0;

        for(int i = 0; i < a.length; i++){
            for(int j = i; j < a.length; j++){
                int thisSum = 0;

                for(int k = i; k <= j; k++){
                    thisSum = thisSum + a[k];
                }

                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Quadratic maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum2(int[] a){
        int maxSum = 0;

        for(int i = 0; i < a.length; i++){
            int thisSum = 0;

            for(int j = i; i < a.length; j++){
                thisSum = thisSum + a[j];

                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
}
