package cz.borderkeeper.kalkulacka;

import java.util.ArrayList;

public class Computer {

    private Screen s;
    private StringBuilder buffer;

    private char curChar;
    private char prevChar;

    private enum Operator { PLUS,MINUS,MOD,TIMES,NUMBER,END }
    private Operator o;
    private int start;
    private ArrayList<Operator> opList;
    private ArrayList<Double> noList;

    public Computer(Screen s) {
        this.s = s;
        buffer = new StringBuilder();
    }

    public void manager(ButtonType t) {
        if(ButtonType.getType(t) == 0){
            start = 0;
            opList = new ArrayList<Operator>();
            noList = new ArrayList<Double>();
            buffer = s.getInput();
            prevChar = 'x';

            int stringLength = buffer.length();
            //Main Loop. Scans the entire input string.
            for(int i = 0;i < stringLength;i++) {
                curChar = buffer.charAt(i);
                //Error handling
                if((((i==0) | (i==stringLength)) & (getOperator(curChar)!=Operator.NUMBER)) | ((getOperator(curChar)!=Operator.NUMBER) & (getOperator(prevChar)!=Operator.NUMBER))) {
                    s.syntaxError();
                    break;
                }

                //Save values to numbers!
                o = getOperator(curChar);
                if((o != Operator.NUMBER) | (i==stringLength-1)) {
                    if(i==stringLength-1) {
                        opList.add(Operator.END);
                        noList.add(getNumber(buffer.subSequence(start, i + 1)));
                    } else {
                        opList.add(o);
                        noList.add(getNumber(buffer.subSequence(start, i)));
                        start = i+1;
                    }
                }
                prevChar = curChar;
            }

            //Logic
            int no;
            int index = 0;
            double result;
            if((no = opList.size()) != noList.size()) {
                s.syntaxError();
                return;
            }
            while(no > 1) {
                if(opList.get(index) == Operator.TIMES) {
                    noList.set(index,noList.get(index)*noList.get(index+1));
                    noList.remove(index+1);
                    opList.remove(index);
                    no = no-1;
                    if(index>0) index--;
                } else if(opList.get(index) == Operator.MOD) {
                    noList.set(index,noList.get(index)/noList.get(index+1));
                    noList.remove(index+1);
                    opList.remove(index);
                    no = no-1;
                    if(index>0) index--;
                } else {
                    if(opList.contains(Operator.TIMES) | opList.contains(Operator.MOD)) {
                        if(index<=no) index++;
                        continue;
                    }
                    if(opList.get(index) == Operator.PLUS) {
                        noList.set(0,noList.get(0)+noList.get(1));
                        noList.remove(1);
                        opList.remove(0);
                        no = no-1;
                    } else if(opList.get(index) == Operator.MINUS) {
                        noList.set(0,noList.get(0)-noList.get(1));
                        noList.remove(1);
                        opList.remove(0);
                        no = no-1;
                    }
                }
            }

            s.print(noList.get(0).toString());

        } else if(ButtonType.getType(t) == 2) {
            s.clearScreen();
            prevChar = 'x';
        } else add(t);
    }

    public void add(ButtonType t) {
        s.append(ButtonType.print(t));
    }

    private Operator getOperator(char s) {
        switch(s) {
            case '+':
                return Operator.PLUS;
            case '-':
                return Operator.MINUS;
            case '*':
                return Operator.TIMES;
            case '/':
                return Operator.MOD;
            default:
                return Operator.NUMBER;
        }
    }

    private double getNumber(CharSequence s) {
        return Double.parseDouble(s.toString());
    }


}
