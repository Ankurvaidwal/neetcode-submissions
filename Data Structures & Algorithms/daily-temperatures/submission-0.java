class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(st.size() >0 && temperatures[i]>temperatures[st.peek()]){
                int prev = st.pop();
                ans[prev]=i-prev;
            }
            st.push(i);
        }

        return ans;
    }
}
