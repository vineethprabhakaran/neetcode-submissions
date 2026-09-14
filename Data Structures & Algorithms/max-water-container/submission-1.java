class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int right = heights.length - 1;
        int left  = 0;
        int min = 0;

        while(left < right){
            min = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, min * (right - left));
            if(heights[left] < heights[right]){
                left++;
            } else {
                right-- ;
            }
        }

        return maxArea;
    }
}
