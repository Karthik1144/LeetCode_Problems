class ProductOfNumbers {
    ArrayList<Integer> lst;
    public ProductOfNumbers() {
        lst = new ArrayList<>();
    }
    
    public void add(int num) {
        lst.add(num);
    }
    
    public int getProduct(int k) {
        int pro = 1;
        for(int i=lst.size()-1;i>=lst.size()-k;i--){
            pro = pro*lst.get(i);
        }
        return pro;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */