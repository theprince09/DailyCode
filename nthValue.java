
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        long count=0;
        int mod=(int)1e9+7;
        long [] arr=new long [n];
        for(int i=0;i<n;i++){
            arr[i]=1;
        }
        while(true){
            count++;
            for(int i=1;i<n;i++){
                arr[i]=(arr[i]+arr[i-1])%mod;
            }
            if(count==k){
                return (int)arr[n-1];
            }
        }
    }
}


public class nthValue {
    public static void main(String[] args) {
        
    }
}
