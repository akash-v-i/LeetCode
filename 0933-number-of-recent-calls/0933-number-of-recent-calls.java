class RecentCounter {
    List<Integer>li;
    public RecentCounter() {
        li=new ArrayList<>();
    }
    
    public int ping(int t) {
        li.add(t);
        int co=0;
        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i)<(t-3000)){
                return co;
            }
            co++;
        }
        return co;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */