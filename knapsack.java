class KS{
    static int max(int a, int b){
        if (a>b) return a;
        else return b;
    }

    static int check( int m, int wt[], int val[], int n, int[][] dp){
        if (n==0 || m==0)
        return 0;
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(wt[n-1] > m){
            return dp[n][m] = check(m,wt, val, n-1, dp);
        }
        else{
            return dp[n][m] = max(val[n-1] + check(m- wt[n-1],wt, val, n-1, dp), check(m, wt, val,n-1, dp));
        }

    }

    static int knapSack(int m , int wt[], int val[], int N){
        int dp[][] = new int[N+1][m+1];
        for(int i=0; i<N+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j]=-1;
            }
        }
        return check(m, wt, val, N, dp);
    }

    public static void main(String[] args) {
            int profit[] = { 6, 10, 12 }; 
    		int weight[] = { 1, 2, 5 }; 
    
    		int m = 5; 
    		int N = profit.length; 
    
    		System.out.println(knapSack(m, weight, profit, N));
        
    }
}

