class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        find(s, "", ans, 0);
        return ans;
    }

    public void find(String str, String res, List<String> ans, int co) {
        if (co == 4 && str.length() > 0)
            return;
        if (str.length() == 0) {
            if(co!=4) return; 
            ans.add(res);
            return;
        }

        if (str.length() >= 3 && str.charAt(0)!='0') {
            int three = Integer.parseInt(str.substring(0, 3));
            if (three <= 255) {
                if (res.length() != 0) {
                    res = res + ".";
                }
                find(str.substring(3), res + str.substring(0, 3), ans, co + 1);
            }
        }

        if (str.length() >= 2 && str.charAt(0)!='0') {
            if (res.length() != 0 && res.charAt(res.length()-1)!='.') {
                res = res + ".";
            }
            find(str.substring(2), res + str.substring(0, 2), ans, co + 1);
        }

        if (res.length() != 0 && res.charAt(res.length()-1)!='.') {
            res = res + ".";
        }
        find(str.substring(1), res + str.substring(0, 1), ans, co + 1);
    }
}