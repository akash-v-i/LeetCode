class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder st=new StringBuilder();
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
            return (b+a).compareTo(a+b);
        });

        for(int x:nums){
            pq.add(Integer.toString(x));
        }

        if(pq.peek().charAt(0)=='0') return "0";
        while(!pq.isEmpty()){
            st.append(pq.poll());
        }
        return st.toString();
    }
}


/*
String arr[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) return "0";

        for(String x:arr){
            st.append(x);
        }
        return st.toString();
*/