class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.frac,b.frac));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double frac = (double) arr[i]/arr[j];
                pq.add(new Pair(frac,new int[]{arr[i],arr[j]}));
            }
        }
        while(k>1){
            pq.poll();
            k--;
        }

        return pq.poll().arr;
    }
    class Pair{
        double frac;
        int arr[];
        Pair(double frac,int[] arr){
            this.frac = frac;
            this.arr = arr;
        }
    }
}