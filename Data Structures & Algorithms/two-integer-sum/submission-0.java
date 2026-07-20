class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                j = map.get(target - nums[i]);
                return new int[] {j, i};
            } else
                map.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
}
