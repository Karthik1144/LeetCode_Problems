class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word:wordList)
            set.add(word);

        if(set.contains(beginWord))
            set.remove(beginWord);

        if(!set.contains(endWord))
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedArray[] = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);

                    if(endWord.equals(replacedWord)){
                        return steps + 1;
                    }

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String word;
        int steps;
        public Pair(String word ,int steps){
            this.word = word;
            this.steps = steps;
        }
    }
}