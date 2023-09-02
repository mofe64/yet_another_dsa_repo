package javafiles;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                characters.add(currentChar);
            } else {
                if (characters.empty()) {
                    characters.add(currentChar);
                } else {
                    char top = characters.peek();
                    if (currentChar == '}' && top == '{') {
                        characters.pop();
                    } else if (currentChar == ')' && top == '(') {
                        characters.pop();
                    } else if (currentChar == ']' && top == '[') {
                        characters.pop();
                    } else {
                        characters.push(currentChar);
                    }
                }
            }
        }

        return characters.empty();
    }
}