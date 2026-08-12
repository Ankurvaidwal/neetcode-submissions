class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (st.size() > 0 && nums2[i] > nums2[st.peek()]) {
                int prev = st.pop();
                map.put(nums2[prev], nums2[i]);
            }
            st.push(i);
        }

        while(st.size() >0){
            map.put(nums2[st.pop()],-1);
        }

        int[] result = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}