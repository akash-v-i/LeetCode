class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int max=0;
        for(int i=0;i<s.length();i++){
            //odd
            int left=i-1;
            int right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if((right-left +1)>max){
                max=right-left +1;
                ans=s.substring(left+1,right);
            }

            //even
            left=i;
            right=i+1;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            if((right-left +1)>max){
                max=right-left+1;
                ans=s.substring(left+1,right);
            }
        }
        System.out.print(max);
        return ans;
    }

}

//b a b a d
//0 1 2 3 4

//c b b d
//0 1 2 3

//b b
//0 1
