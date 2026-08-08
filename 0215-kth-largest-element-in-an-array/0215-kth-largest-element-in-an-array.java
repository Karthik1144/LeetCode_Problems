class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int num:nums)
            q.offer(num);

        int remove = nums.length-k;

        while(remove-->0){
            q.poll();
        }
        return q.peek();
    }
}