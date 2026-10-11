class Solution {
    public boolean isPalindrome(String s) {
        String str = s.trim().toLowerCase();
        int l = 0;
        int r = str.length()-1;
        char[] ch = str.toCharArray();
        

        while(l < r){
            while(l < r && !Character.isDigit(ch[l]) && !Character.isLetter(ch[l])){
                l++;
            }

            while(l < r && !Character.isDigit(ch[r]) && !Character.isLetter(ch[r])){
                r--;
            }

            if(ch[l] != ch[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
        
    }
}
