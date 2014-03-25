package cz.borderkeeper.kalkulacka;

public enum ButtonType {
    PLUS,MINUS,TIMES,MOD,EQUALS,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,ZERO,CLEAR;


    public static int getType(ButtonType id) {
        switch (id) {
            case EQUALS:
                return 0;
            case PLUS:
            case MINUS:
            case TIMES:
            case MOD:
                return 1;
            case CLEAR:
                return 2;
            default:
                return 3;
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
        }
        return "err";
    }
}
