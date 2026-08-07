class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                st.push(Integer.parseInt(str));

            } else {
                int b = st.pop();
                int a = st.pop();

                switch (str) {
                    case "+":
                        st.push(a + b);
                        break;

                    case "-":
                        st.push(a - b);
                        break;

                    case "*":
                        st.push(a * b);
                        break;

                    case "/":
                        st.push(a / b);
                        break;
                }
            }
        }

        return st.pop();
    }
}
