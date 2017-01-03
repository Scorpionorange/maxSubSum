/**
 * Created by ScorpionOrange on 2017/01/02.
 */
public class MaxSubSum {
    public static void main(String[] args){
        int[] a = new int[1000];
        for(int i = 0; i < a.length; i++){
            a[i] = (int)(Math.random() * 100);
        }
        int output1 = maxSubSum1(a);
        int output2 = maxSubSum2(a);
        int output3 = maxSubSum3(a);
        int output4 = maxSubSum4(a);

        System.out.println("output1 = " + output1);
        System.out.println("output2 = " + output2);
        System.out.println("output3 = " + output3);
        System.out.println("output4 = " + output4);
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

            for(int j = i; j < a.length; j++){
                thisSum += a[j];

                if(thisSum > maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Recursive maximum contiguous subsequence sum algorithm.
     * Finds maximum sum in subarray spanning a[left...right].
     * Does not attempt to maintain actual best sequence.
     */
    private static int maxSumRec(int[] a, int left, int right){
        if(left == right) {// Base case
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorberSum = 0;
        for( int i = center; i >= left; i--){
            leftBorberSum += a[i];
            if(leftBorberSum > maxLeftBorderSum){
                maxLeftBorderSum = leftBorberSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i = center + 1; i <= right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        int theMax = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
        theMax = theMax > (maxLeftBorderSum + maxRightBorderSum) ? theMax : (maxLeftBorderSum + maxRightBorderSum);
        return theMax;
    }

    /**
     * Driver for divide-and-conquer maximum contiguous
     * subsequence sum algorithm.
     */
    public static int maxSubSum3(int[] a){
        return maxSumRec(a, 0, a.length - 1);
    }

    /**
     * Liner-time maximum contiguous subsequence sum algorithm.
     */
    public static int maxSubSum4(int[] a){
        int maxSum = 0, thisSum = 0;

        for(int i = 0; i < a.length; i++){
            thisSum += a[i];

            if(thisSum > maxSum){
                maxSum = thisSum;
            }
            else if (thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
