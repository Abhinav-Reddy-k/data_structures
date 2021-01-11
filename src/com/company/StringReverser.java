package com.company;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : input.toCharArray())
            stack.push(c);

        StringBuilder reverse = new StringBuilder();
        while(!stack.isEmpty())
            reverse.append(stack.pop());

        return reverse.toString();
    }
}
