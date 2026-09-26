class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partition(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void partition(String s,int index,List<String> a,List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                a.add(s.substring(index,i+1));
                partition(s,i+1,a,ans);
                a.remove(a.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}