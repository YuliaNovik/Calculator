package com.example.calculator;
import java.util.*;

public class CalcBrain {

     ArrayList<String> expressionList;
     ArrayList<String> history;

    public CalcBrain() {
        expressionList = new ArrayList<>();
        history = new ArrayList<>();
    }

    public void push(String value) {
        expressionList.add(value);
    }
    public void pushHistory(String value) {
        history.add(value);
    }

    private boolean validate(ArrayList<String> list) {
        if (list.size() < 3 || list.size() % 2 == 0) {
            return false;
        }

        for (int i = 0; i < list.size(); i += 2) {
            if (!list.get(i).matches("[0-9]") || (i + 1 < list.size() && !list.get(i + 1).matches("[+\\-*/]"))) {
                return false;
            }
        }
        return true;
    }

    public int calculate() {
        if (expressionList.size() == 0 || expressionList.size() % 2 == 0 ||!validate(expressionList)) {
            return -1000;
        }

        int result = Integer.parseInt(expressionList.get(0));
        for (int i = 1; i < expressionList.size(); i += 2) {
            String operator = expressionList.get(i);

            if (i + 1 < expressionList.size()) {
                String operand = expressionList.get(i + 1);

                int num = Integer.parseInt(operand);
                switch (operator) {
                    case "+":
                        result += num;
                        break;
                    case "-":
                        result -= num;
                        break;
                    case "*":
                        result *= num;
                        break;
                    case "/":
                        if (num == 0) {
                            return -2000; //  handle division by zero
                        }
                        result /= num;
                        break;
                }
            }
        }
        return result;
    }

//    public String getHistory() {
//        StringBuilder expression = new StringBuilder();
//        for (String value : history) {
//            expression.append(value);
//           // System.out.println( expression.toString());
//        }
//        return expression.toString();
//    }



}
