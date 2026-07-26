package day0723;

import java.util.ArrayDeque;
import java.util.Deque;

public class BracketValidationSystem {
    public static boolean isValidBrackets(String input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String[] testCases = {
            "a * (b + c) - [d / {e}]",  
            "{[()]}",                 
            "((a + b)",              
            "a + b)",
            "( [ ) ]",                   
            "}{"                       
        };

        System.out.println("=== 開始括號驗證測試 ===");
        for (String test : testCases) {
            boolean result = isValidBrackets(test);
            System.out.printf("測試字串: %-25s -> 驗證結果: %s\n", 
                              "\"" + test + "\"", 
                              result ? "【正確】" : "【不合法】");
        }
    }
}
