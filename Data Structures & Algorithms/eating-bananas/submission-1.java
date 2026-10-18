class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h == 0) return 0;

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while(l < r){
            int mid = (l + r) /2;
            long totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double) pile / mid);
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
