class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> arr = new HashSet<Integer>();
        for (int num : nums) {
            if (arr.contains(num))
                return true;
            else
                arr.add(num);
        }
        return false;
    }
}