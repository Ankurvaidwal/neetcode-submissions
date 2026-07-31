class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] sFreq = getFrequencyArray(s1, s1.length());
        int[] currentFreq = getFrequencyArray(s2, s1.length());
        if (isPermutation(sFreq, currentFreq))
            return true;
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            currentFreq[s2.charAt(left) - 'a']--;
            currentFreq[s2.charAt(right) - 'a']++;
            if (isPermutation(sFreq, currentFreq)) {
                return true;
            }
            left++;
        }
        return false;
    }

    public int[] getFrequencyArray(String str, int n) {
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i) - 'a']++;
        }
        return freq;
    }

    public boolean isPermutation(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}
