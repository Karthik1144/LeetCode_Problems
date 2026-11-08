class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        });

        for(String str:nums){
            pq.offer(str);
        }
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}