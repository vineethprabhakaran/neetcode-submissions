class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h == 0) return 0;
        int maxVal = 0;
        for(int pile : piles){
            maxVal = Math.max(maxVal, pile);
        }

        int l = 1;
        int r = maxVal;
        while(l < r){
            int mid = l + (r - l)/2;
            long totalTime = 0;
            for(int pile : piles){
                totalTime += (pile + (mid - 1))/mid;
            }
            if(totalTime <= h){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
        
    }
}
