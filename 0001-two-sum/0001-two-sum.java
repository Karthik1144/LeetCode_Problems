class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff))   return new int[]{map.get(diff),i};
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}


//The 2 pointer technique is not suitable for the give cases as the technique needs a sorted array unlike a unsorted array.


// class Solution{
//     public int[] twoSum(int[] nums, int target) {
//         int left = 0,right=nums.length-1;
//         while(left<=right){
//             int sum = nums[left]+nums[right];
//             System.out.println(sum);
//             if(sum==target)
//                 return new int[]{left,right};
//             if(sum>target || left==0)
//                 right--;
//             if(sum<target || right == nums.length-1)
//                 left++;
//         }
//         return new int[]{-1,-1};
//     }
// }