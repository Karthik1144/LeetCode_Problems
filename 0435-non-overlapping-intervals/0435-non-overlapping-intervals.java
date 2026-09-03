class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        List<int[]> newList = new ArrayList<>();
        for(int interval[] : intervals){
            if(newList.size() == 0)
                newList.add(interval);
            else if(newList.get(newList.size()-1)[1]<=interval[0])
                newList.add(interval);
        }
        return intervals.length - newList.size();
    }
}