package com.dk.codeproblems;

public class IsStringIsValidNumber {
    enum STATE {START, INTEGER, DECIMAL, AFTERDECIMAL, UNKNOWN;}
    public static boolean isNumberValid(String input){
        if(input.isBlank()){
            return true;
        }

        int i = 0;
        // Ignore starting character + or - sign
        if(input.charAt(i)=='+' || input.charAt(i)=='-'){
            i = i + 1;
        }
        STATE currentState = STATE.START;
        while(i < input.length()){
            currentState = getNextState(currentState, input.charAt(i));
            if(currentState == STATE.UNKNOWN){
                return false;
            }
            i++;
        }
        if(currentState == STATE.DECIMAL){
            return false;
        }

        return true;
    }

    public static STATE getNextState(STATE currentState, char ch){
        switch(currentState){
            case START:
            case INTEGER:
             if(ch >='0' && ch <= '9'){
                 return STATE.INTEGER;
             }else if(ch == '.'){
                 return STATE.DECIMAL;

             }else{
                 return STATE.UNKNOWN;
             }
             case DECIMAL:
                 if(ch >='0' && ch <= '9'){
                     return STATE.AFTERDECIMAL;
                 }else{
                     return STATE.UNKNOWN;
                 }
            case AFTERDECIMAL:
                if (ch >= '0' && ch <= '9') {
                    return STATE.AFTERDECIMAL;
                } else {
                    return STATE.UNKNOWN;
                }
        }
        return STATE.UNKNOWN;
    }

    public static void main(String ...args){
        System.out.println("Is the number valid 4.325? " + isNumberValid("4.325"));
        System.out.println("Is the number valid 1.1.1? " + isNumberValid("1.1.1"));
        System.out.println("Is the number valid 222? " + isNumberValid("222"));
        System.out.println("Is the number valid 22.? " + isNumberValid("22."));
        System.out.println("Is the number valid 0.1? " + isNumberValid("0.1"));
        System.out.println("Is the number valid 22.22.? " + isNumberValid("22.22."));
        System.out.println("Is the number valid 1.? " + isNumberValid("1."));
        System.out.println("Is the number valid 22.22.? " + isNumberValid("+22.22"));
        System.out.println("Is the number valid 1.? " + isNumberValid("-1."));
        System.out.println("Is the number valid 22.22.? " + isNumberValid("-22.22"));
    }


}
