class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch != ')') {
                stack.push(ch);
            } 
            else {
                // Extract everything until '('
                StringBuilder temp = new StringBuilder();

                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                // Remove '('
                stack.pop();

                // Put reversed string back
                for (char c : temp.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
