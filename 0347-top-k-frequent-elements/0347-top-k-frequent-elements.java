class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hs=new HashMap<>();
        for(int x:nums){
            hs.putIfAbsent(x,0);
            hs.put(x,hs.get(x)+1);
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)-> hs.get(a)-hs.get(b));
        for(int x:hs.keySet()){
            pq.add(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int arr[]=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.poll();
        }
        return arr;
    }
}