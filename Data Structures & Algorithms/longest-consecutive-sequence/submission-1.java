class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        int maxLen = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }
}
