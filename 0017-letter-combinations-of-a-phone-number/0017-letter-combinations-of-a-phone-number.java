class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> ans = new ArrayList<>();
        helper(digits,0,"",ans,map);
        return ans;
    }
    public void helper(String digits,int index,String current,
        List<String> ans,HashMap<Integer,String>map){
        if(index==digits.length()){
            ans.add(current);
            return;
        }
        String s = map.get(digits.charAt(index)-'0');
        for(int i=0;i<s.length();i++){
            helper(digits,index+1,current+s.charAt(i),ans,map);
        }
    }
}