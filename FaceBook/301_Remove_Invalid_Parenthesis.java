public class _301_Remove_Invalid_Parantheses {
    /*public static String removeInvalidParentheses(String s) {
        int counter = 0;
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        //first pass : remove invalid ')'
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                counter++;
                sb.append('(');
            } else if (c[i] == ')') {
                if (counter > 0) {
                    counter--;
                    sb.append(')');
                }
            }
        }
        //second pass : remove invalid '('
        c = sb.toString().toCharArray();
        sb = new StringBuilder();
        counter = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == ')') {
                counter++;
                sb.append(')');
            } else if (c[i] == '(') {
                if (counter > 0) {
                    counter--;
                    sb.append('(');
                }
            }
        }
        return sb.reverse().toString();
    }*/
    public static int removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        //first pass: remove invalid ')'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
                sb.append('(');
            } else if (s.charAt(i) == ')') {
                if (counter > 0) {
                    counter--;
                    sb.append(')');
                }
            }
        }
        //second pass: remove invalid '('
        int res = 0;
        counter = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ')') {
                counter++;
                res++;
            } else if (sb.charAt(i) == '(') {
                if (counter > 0) {
                    counter--;
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String test1 = "()())(()";
        String test2 = "()a(()";
        String test3 = ")(";
        System.out.println(removeInvalidParentheses(test1));
        System.out.println(removeInvalidParentheses(test2));
        System.out.println(removeInvalidParentheses(test3));
    }
}