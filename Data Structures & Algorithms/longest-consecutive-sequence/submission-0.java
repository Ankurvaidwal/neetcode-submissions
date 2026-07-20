class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        int maxLen = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;
                while (true) {
                    if (set.contains(curr + 1)) {
                        len += 1;
                        curr++;
                    } else
                        break;
                }
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }
}
