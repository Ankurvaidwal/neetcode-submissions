class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while (left < right) {
            int wt = right-left;
            int ht = Math.min(heights[left],heights[right]);
            int area = ht*wt;
            maxArea = Math.max(maxArea,area);
            if(heights[left]>heights[right]) right--;
            else left++;
        }

        return maxArea;
    }
}
