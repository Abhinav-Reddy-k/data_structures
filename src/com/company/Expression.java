package com.company;

import java.util.Stack;

public class Expression {
    public static boolean isBalenced(String input) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : input.toCharArray()){
            if (c == '('){
                stack.push(c);
            }
            if (c == ')') {
                if (stack.empty()) return false;
                stack.pop();
            }
        }

        return stack.empty();
    }
}
