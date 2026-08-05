class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();

        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (Character ch : s.toCharArray()) {
            if (!pairs.containsKey(ch)) {
                stack.push(ch);

            } else {
                if (stack.isEmpty())
                    return false;

                if (stack.peek() != pairs.get(ch))
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
