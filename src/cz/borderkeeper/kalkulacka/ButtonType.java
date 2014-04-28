package cz.borderkeeper.kalkulacka;

public enum ButtonType {
    PLUS,MINUS,TIMES,MOD,FACT,EXP,SQRT,EQUALS,DOT,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,ZERO,CLEAR,MEMORYCLEAR,MEMORYSAVE,MEMORYLOAD;


    public static int getType(ButtonType id) {
        switch (id) {
            case EQUALS:
                return 0;
            case PLUS:
            case MINUS:
            case TIMES:
            case MOD:
            case EXP:
                return 1;
            case CLEAR:
                return 2;
            case MEMORYLOAD:
                return 3;
            case MEMORYCLEAR:
                return 4;
            case MEMORYSAVE:
                return 5;
            case FACT:
            case SQRT:
                return 6;
            default:
                return 7;
        }
    }

    public static String print(ButtonType id) {
        switch (id) {
            case PLUS:
                return "+";
            case MINUS:
                return "-";
            case TIMES:
                return "*";
            case MOD:
                return "/";
            case EQUALS:
                return "=";
            case DOT:
                return ".";
            case FACT:
                return "!";
            case EXP:
                return "^";
            case SQRT:
                return "√";
            case ONE:
                return "1";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case ZERO:
                return "0";
            case CLEAR:
                return "C";
            case MEMORYCLEAR:
                return "MClear";
            case MEMORYLOAD:
                return "MLoad";
            case MEMORYSAVE:
                return "MSave";
        }
        return "err";
    }
}
