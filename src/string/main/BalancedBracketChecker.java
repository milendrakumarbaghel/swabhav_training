package string.main;

public class BalancedBracketChecker {
    public boolean isBalanced(String str) {
        char[] stack = new char[str.length()];
        int top = -1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
            } else if (ch == ')' || ch == ']' || ch == '}') {

                if (top == -1) {
                    return false;
                }

                char open = stack[top--];
                if ((ch == ')' && open != '(') ||
                        (ch == ']' && open != '[') ||
                        (ch == '}' && open != '{')) {
                    return false;
                }
            }
        }

        return top == -1;
    }
}
