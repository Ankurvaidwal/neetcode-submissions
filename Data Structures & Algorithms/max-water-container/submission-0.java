class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0,area=0, wt = 0, ht = 0;
        while (left < right) {
            wt = right-left;
            ht = Math.min(heights[left],heights[right]);
            area = ht*wt;
            maxArea = Math.max(maxArea,area);
            if(heights[left]>heights[right]) right--;
            else left++;
        }

        return maxArea;
    }
}
