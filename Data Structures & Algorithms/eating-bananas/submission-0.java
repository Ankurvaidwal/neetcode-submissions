class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(piles, h, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }

    boolean isValid(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;

            if (hours > h)
                return false;
        }

        return true;
    }
}
