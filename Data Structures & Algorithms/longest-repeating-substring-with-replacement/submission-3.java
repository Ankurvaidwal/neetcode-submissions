class Solution {
public int characterReplacement(String s, int k) {

    HashMap<Character, Integer> freq = new HashMap<>();

    int left = 0;
    int maxFreq = 0;
    int maxWindow = 0;

    for (int right = 0; right < s.length(); right++) {

        // Add current character to the window
        char ch = s.charAt(right);
        freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        // Update max frequency (never decreases)
        maxFreq = Math.max(maxFreq, freq.get(ch));

        // Current window size
        int windowLength = right - left + 1;

        // If window is invalid, shrink once
        if (windowLength - maxFreq > k) {
            char leftChar = s.charAt(left);
            freq.put(leftChar, freq.get(leftChar) - 1);
            left++;
        }

        // Update answer
        maxWindow = Math.max(maxWindow, right - left + 1);
    }

    return maxWindow;
}
}
