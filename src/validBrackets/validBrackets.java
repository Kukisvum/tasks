package validBrackets;

import java.util.ArrayList;
import java.util.Stack;
/*
Задачка:
Найти валидные круглые скобки.
Обязательно счетчик и правильные скобки нужно выводить.
Пример 1:
               Ввод: "(()"
               Вывод: 2 - ()
Пример 2:
               Ввод: ")()())"
               Вывод: 4 - ()()
Пример 3:
               Ввод: ")(()())"
               Вывод: 6 - (()())
Пример 4:
               Ввод: ")("
               Вывод: 0
*/


public class validBrackets {
    public static void main(String[] args) {
        String test1 = "(()";
        String test2 = ")()())";
        String test3 = ")(()())";
        String test4 = "";
        String test5 = "((((()()(((()(dkjfnslkfbf)";
        String test6 = ")))(((()))))))))()()()((((((()";

        System.out.println(validBrackets(test3));
    }


    public static String validBrackets(String str) {
        String s = str.replaceAll("[^()]","");
        if (s.length() == 0 || s.length() < 2) {
            return String.valueOf(0);
        }
        String currentParentheses = "";
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        ArrayList<String> resultList = new ArrayList<>();
        int j = 0;
        resultList.add("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    if (s.substring(stack.peek()+1, i+1).length() <= currentParentheses.length()) {
                        resultList.add("");
                        j++;
                    }
                    currentParentheses=s.substring(stack.peek()+1, i+1);
                    resultList.set(j,currentParentheses);
                }
            }
        }
        String validParentheses="";
        for (String name: resultList) {
            validParentheses += name;
        }
        if (validParentheses.length()==0) {
            return String.valueOf(0);
        } else {
            return validParentheses.length() + " - " + validParentheses;
        }

    }
}
