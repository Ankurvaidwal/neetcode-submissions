class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i)))
                hash.put(s.charAt(i), hash.get(s.charAt(i)) + 1);
            else
                hash.put(s.charAt(i), 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (hash.size() > 0 && hash.containsKey(t.charAt(i))) {
                hash.put(t.charAt(i), hash.get(t.charAt(i)) - 1);
                if (hash.get(t.charAt(i)) < 0)
                    return false;
            } else
                return false;
        }
        for (Integer value : hash.values()) {
            if (value != 0)
                return false;
        }

        return true;
    }
}
