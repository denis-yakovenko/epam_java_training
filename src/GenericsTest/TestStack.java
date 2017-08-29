package GenericsTest;

import java.util.Arrays;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        new TestStack().go();
    }

    private void go() {
        Integer[] a = {4, 8, 15, 16, 32, 42};
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(s));
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(s));
        System.out.println(isMatched("{(5+x)*<a+b>+<4-(y+z)>}"));
        System.out.println(isHTMLMatched("<body>\n" +
                "<center>\n" +
                "<h1> The Little Boat </h1>\n" +
                "</center>\n" +
                "<p> The storm tossed the little\n" +
                "boat like a cheap sneaker in an\n" +
                "old washing machine. The three\n" +
                "drunken fishermen were used to\n" +
                "such treatment, of course, but\n" +
                "not the tree salesman, who even as\n" +
                "a stowaway now felt that he\n" +
                "had overpaid for the voyage. </p>\n" +
                "<ol>\n" +
                "<li> Will the salesman die? </li>\n" +
                "<li> What color is the boat? </li>\n" +
                "<li> And what about Naomi? </li>\n" +
                "</ol>\n" +
                "</body>"));
    }

    private <E> void reverse(E[] a) {
        Stack<E> stack = new Stack<>();
        for (E elem : a) {
            stack.push(elem);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = stack.pop();
        }
    }

    private boolean isMatched(String expression) {
        final String opening = "<({";
        final String closing = ">)}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            //for (char c : expression.toCharArray()) {
            //System.out.println(i + " " + stack.toString());
            if (opening.indexOf(c) != -1) {
                stack.push(c);
                System.out.println(i + " open " + c);
            } else if (closing.indexOf(c) != -1) {
                if (stack.isEmpty()) return false;
                System.out.println(i + " close " + c);
                if (closing.indexOf(c) != opening.indexOf(stack.pop()))
                    return false;
            }
            //System.out.println(i + " " + stack.toString());
        }
        return stack.isEmpty();
    }

    private boolean isHTMLMatched(String html) {
        Stack<String> stack = new Stack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) return false;
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) stack.push(tag);
            else {
                if (stack.isEmpty()) return false;
                if (!tag.substring(1).equals(stack.pop()))
                    return false;
            }
            j = html.indexOf('<', k + 1);
        }
        return stack.isEmpty();
    }

}
