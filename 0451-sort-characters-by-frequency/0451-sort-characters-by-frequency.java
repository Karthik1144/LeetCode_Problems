class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.freq,a.freq));
        for(char key:map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            String con = String.valueOf(node.ch).repeat(node.freq);
            sb.append(con);
        }
        return sb.toString();
    }
    class Pair{
        char ch;
        int freq;
        public Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
}