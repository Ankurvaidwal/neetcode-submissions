class Solution {
    public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int formed = 0;
        int required = need.size();
        int left = 0;

        int bestLength = Integer.MAX_VALUE;
        int bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < bestLength) {
                    bestLength = right - left + 1;
                    bestStart = left;
                }
                c = s.charAt(left);
                window.put(c, window.get(c) - 1);
                if (need.containsKey(c) && window.get(c) < need.get(c)) {
                    formed--;
                }
                left++;
            }
        }

        if (bestLength == Integer.MAX_VALUE)
            return "";

        return s.substring(bestStart, bestStart + bestLength);
    }
}
