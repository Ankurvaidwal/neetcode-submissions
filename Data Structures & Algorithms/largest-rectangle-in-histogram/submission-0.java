class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                int area = heights[mid] * width;
                maxArea = Math.max(area, maxArea);
            }
            if (i != n)
                stack.push(i);
        }
        return maxArea;
    }
}
