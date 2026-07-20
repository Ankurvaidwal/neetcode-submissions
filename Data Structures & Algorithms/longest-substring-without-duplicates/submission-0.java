class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max=0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                max = Math.max(max,set.size());
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
        }
        return Math.max(max,set.size());
    }
}
