class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int prev = 0;

        for(int i=0; i<arr.length; i++){
                int num=arr[i];
            count += num - prev - 1;
            if (count >= k) {
                return prev + k - (count - (num - prev - 1));
            }
            prev = num;
        }
        return arr[arr.length - 1] + k - count;
    }

    public static void main(String args[]) {
        int values[] = {1, 2, 5, 6}; // values of items
        Solution s = new Solution();
        System.out.println(s.findKthPositive(values, 4));
    }
}

