class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int totalWater = 0;
        int maxWater = 0;

        while(i < j){
            totalWater = Math.min(heights[i], heights[j]) * (j-i);
            maxWater = Math.max(maxWater, totalWater);

            if(heights[i] <= heights[j]){
                i++;
            }else{
                j--;
            }

        }

        return maxWater;

    }
}
