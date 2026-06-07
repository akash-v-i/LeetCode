class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int x1=0,x2=0;
        int c1=0,c2=0;

        for(int x:nums){
            if(x1==x){
                c1++;
            }
            else if(x2==x){
                c2++;
            }
            else if(c1==0){
                c1=1;
                x1=x;
            }
            else if(c2==0){
                c2=1;
                x2=x;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
            c2=0;
            for(int a:nums){
                if(x1==a){
                    c1++;
                }
                if(x1!=x2 && x2==a){
                    c2++;
                }
            }
            List<Integer>li=new ArrayList<>();
            if(c1>(nums.length/3)){
                li.add(x1);
            }
            if(c2>(nums.length/3)){
                li.add(x2);
            }
        return li;
    }
}