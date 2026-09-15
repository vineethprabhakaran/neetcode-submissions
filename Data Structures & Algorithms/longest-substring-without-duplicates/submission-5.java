class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength  = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
               
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;

    }
}
 