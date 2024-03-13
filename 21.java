// class FindMissingKthValue {
//     public static int findMissingKthValue(int[] arr, int k) {
//         int n = arr.length;
//         int prev = arr[0];
        
//         for (int i = 1; i < n; i++) {
//             int diff = arr[i] - prev;
//             int missingCount = (diff - 1) / 4;
//             if (missingCount >= k) {
//                 // The kth missing value is between prev and arr[i]
//                 return prev + 4 * (k - 1); // Correcting k value
//             }
//             // Update prev for the next iteration
//             prev = arr[i];
//             // Update k for the next iteration
//             k -= missingCount;
//         }
        
//         // If the kth missing value is beyond the last element of the array
//         return arr[n - 1] + 4 * (k - 1); // Correcting k value
//     }

//     public static void main(String[] args) {
//         int[] arr = {2, 6, 18, 22};
//         int k = 2;
//         System.out.println("The " + k + "th missing value is: " + findMissingKthValue(arr, k));
//     }
// }

 class KthMissingEven {

    public static int findMissingKthEven(int[] arr, int k) {
        int count = 0;
        int num = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            while (num < arr[i]) {
                count++;
                if (count == k) {
                    return num;
                }
                num += 2;
            }
            num += 2;
        }
        
        // If kth missing even is beyond the end of the array
        while (count < k) {
            count++;
            num += 2;
        }
        
        return num - 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 14};
        int k = 2;
        System.out.println("The " + k + "nd missing even number is: " + findMissingKthEven(arr, 2));
    }
}
