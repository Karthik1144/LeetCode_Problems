class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length , ans = 0;
        for(int i=0;i<n;i++){
            int evenCount = 0 , oddCount = 0; 
            for(int j=i;j<n;j++){
                if(nums[j]%2==0)
                    evenCount++;
                else
                    oddCount++;

                if(oddCount>0 && evenCount*b <= oddCount*a)
                    ans++;
            }
        }
        return ans;
    }
}