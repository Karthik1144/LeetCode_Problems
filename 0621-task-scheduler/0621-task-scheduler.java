class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(char ch:tasks)  
            freq[ch - 'A']++;

        int maxFreq = 0;
        for(int f : freq)
            maxFreq = Math.max(maxFreq,f);

        int maxFreqCount = 0;
        for(int f:freq){
            if(f==maxFreq)
                maxFreqCount ++;
        }

        int result = (maxFreq-1)*(n+1)+maxFreqCount;

        return Math.max(tasks.length,result);
    }
}