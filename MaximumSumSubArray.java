class MaximumSumSubarray {
    public static int maxSubarraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0; i<arr.length; i++){
            int num= arr[i];
            currentSum=Math.max(num, currentSum+num);
            maxSum=Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {7,-5,4,6,-3,-6,-2,7,8};
        System.out.println("Maximum sum of sub-array: " + maxSubarraySum(arr));
    }
}

//time complexity = O(n)