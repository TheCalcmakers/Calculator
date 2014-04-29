package cz.borderkeeper.kalkulacka;

import java.util.ArrayList;
/*
 * @author The CalcMakers
 * @date 22.4.2014
 * @version 1.0.0
 *
 * @note Class executing the commands set by user. Is able to calculate any string passed to it.
 */
public class Computer {

    private Screen s;

    private enum Operator { PLUS,MINUS,MOD,TIMES,EXP,NUMBER,END }
    private Operator o;
    private int start;
    private ArrayList<Operator> opList;
    private ArrayList<Double> noList;

    private double memory;
   /*
    * @brief Constructor clearing the memory and passing the screen reference object.
    * @param s Reference screen object.
    */
    public Computer(Screen s) {
        this.s = s;
        memory = 0;
    }
   /*
    * @brief Main directory, which decides action taken.
    * @details This method is called upon button press and depending on the type of button does actions.
    * @param t Button pressed.
    */
    public void manager(ButtonType t) {
        switch(ButtonType.getType(t)) {
            case 0:
                s.print(Double.toString(calculateString()));
                break;
            case 1:
                //Operation +,-,/,*,^
                add(t);
                break;
            case 2:
                //Clear screen
                s.clearScreen();
                break;
            case 3:
                //load from Memory
                s.append(" " + Double.toString(memory));
                calculateString();
                break;
            case 4:
                //Memory clear
                memory = 0;
                s.print("Memory cleared!");
                break;
            case 5:
                //save into Memory
                memory = calculateString();
                s.print(Double.toString(memory) + " saved into memory!");
                break;
            case 6:
                //Operation !,sqrt
                add(t);
                break;
            default:
                add(t);
        }
    }

   /*
    * @brief Adds to input string in Screen a char represented by Button.
    * @param t Type of button.
    */
    public void add(ButtonType t) {
        s.append(ButtonType.print(t));
    }

   /*
    * @brief Converts a char to enum Operator.
    * @param cs char (number or operator)
    */
    private Operator getOperator(char cs) {
        switch(cs) {
            case '+':
                return Operator.PLUS;
            case '-':
                return Operator.MINUS;
            case '*':
                return Operator.TIMES;
            case '/':
                return Operator.MOD;
            case '^':
                return Operator.EXP;
            default:
                return Operator.NUMBER;
        }
    }

   /*
    * @brief Converts a CharSequence (different string) to a double.
    * @details Scans for bad characters in the sequence. Automatically calculates square root and factorial. Also can process a delimiter.
    * @param cs Number beggining with √(sqrt char) or ending with !(factorial char)
    * @return Calculated double or -1 and ends the process with an error.
    */
    private double getNumber(CharSequence cs) {
        for(int i=0;i<cs.length();i++) {
            if((cs.charAt(i) == '√' & i!=0) | (cs.charAt(i) == '!' & i!=(cs.length()-1))) {
                s.syntaxError();
                return -1;
            }
        }

        if(cs.charAt(0)=='√') return MathLib.mySqrt(Double.parseDouble(cs.subSequence(1,cs.length()).toString()));
        if(cs.charAt(cs.length()-1)=='!') return MathLib.factorial(Integer.parseInt(cs.subSequence(0,cs.length()-1).toString()));
        return Double.parseDouble(cs.toString());
    }

   /*
    * @brief Converts an input string into result.
    * @details Splits the input into numbers and operators and puts them into ArrayLists. Then it calculates them.
    * @see https://www.dropbox.com/s/1w70p9jwvntpwff/calculateString.jpg
    * @return Calculated double or ends the process.
    */
    public double calculateString() {
        start = 0;
        double num;
        opList = new ArrayList<Operator>();
        noList = new ArrayList<Double>();

        StringBuilder b = s.getInput();
        if(b.length()==0) return 0;
        int stringLength = b.length();
        //Main Loop. Scans the entire input string.
        for(int i = 0;i < stringLength;i++) {
            //Save values to numbers!
            o = getOperator(b.charAt(i));
            if((o != Operator.NUMBER) | (i==stringLength-1)) {
                if(i==stringLength-1) {
                    opList.add(Operator.END);
                    if((num = getNumber(b.subSequence(start, i + 1))) == -1) break;
                    noList.add(num);
                } else {
                    opList.add(o);
                    if((num = getNumber(b.subSequence(start, i))) == -1) break;
                    noList.add(num);
                    start = i+1;
                }
            }
        }

        //Logic
        int no;
        int index = 0;
        if((no = opList.size()) != noList.size()) {
            s.syntaxError();
            return -1;
        }
        //Do the math
        while(no > 1) {
            if(opList.get(index) == Operator.EXP) {
                noList.set(index,MathLib.myPow(noList.get(index),noList.get(index+1)));
                noList.remove(index+1);
                opList.remove(index);
                no = no-1;
                if(index>0) index=0;
            } else {
                if(opList.contains(Operator.EXP)) {
                    if(index<=no) index++;
                    continue;
                }
                if(opList.get(index) == Operator.TIMES) {
                    noList.set(index,MathLib.mul(noList.get(index),noList.get(index+1)));
                    noList.remove(index+1);
                    opList.remove(index);
                    no = no-1;
                    if(index>0) index=0;
                } else if(opList.get(index) == Operator.MOD) {
                    noList.set(index,MathLib.mod((index),(noList.get(index+1))));
                    noList.remove(index+1);
                    opList.remove(index);
                    no = no-1;
                    if(index>0) index=0;
                } else {
                    if(opList.contains(Operator.TIMES) | opList.contains(Operator.MOD)) {
                        if(index<=no) index++;
                        continue;
                    }
                    if(opList.get(index) == Operator.PLUS) {
                        noList.set(0,MathLib.add(noList.get(0),noList.get(1)));
                        noList.remove(1);
                        opList.remove(0);
                        no = no-1;
                    } else if(opList.get(index) == Operator.MINUS) {
                        noList.set(0,MathLib.sub(noList.get(0),noList.get(1)));
                        noList.remove(1);
                        opList.remove(0);
                        no = no-1;
                    }
                }
            }
        }
        return noList.get(0);
    }
}
