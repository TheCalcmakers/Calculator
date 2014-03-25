package cz.borderkeeper.kalkulacka;

public class Computer {

    Screen s;

    public Computer(Screen s) {
        this.s = s;
    }

    public void manager(ButtonType t) {
        if(ButtonType.getType(t) == 0){
            String input = s.getInput().toString();
            //char buffer[50];

            for(int i = 0;i < input.length();i++) {
                if(isOperator(input.charAt(i))) {
                    //do shit
                } //else buffer[i] = input.charAt(i);
            }
        } else if(ButtonType.getType(t) == 2) {
            s.clearScreen();
        } else add(t);
    }

    public void add(ButtonType t) {
        s.append(ButtonType.print(t));
    }

    private boolean isOperator(char s) {
        if(s=='+' || s=='-' || s=='*' || s=='/') {
            return true;
        }
        return false;
    }

}
