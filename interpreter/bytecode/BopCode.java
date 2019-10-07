package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {

    private String operator;
    private int operand1;
    private int operand2;

    @Override
    public void init(ArrayList<String> args) {

        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        // pop operand in order
        operand2 = vm.pop();
        operand1 = vm.pop();

        // create switch-cases
        switch(operator){
            case "+":
                vm.push(operand1 + operand2);
                break;
            case "-":
                vm.push(operand1 - operand2);
                break;
            case "*":
                vm.push(operand1 * operand2);
                break;
            case "/":
                vm.push(operand1 / operand2); // don't worry about dividing by zero
                break;
            case "==":
                if(operand1 == operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case "!=":
                if(operand1 != operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case "<=":
                if(operand1 <= operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case ">":
                if(operand1 > operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case ">=":
                if(operand1 >= operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case "<":
                if(operand1 < operand2){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case "|":
                if(operand1 == 1 || operand2 == 1){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
            case "&":
                if(operand1 == 1 && operand2 == 1){
                    vm.push(1);
                }else{
                    vm.push(0);
                }
                break;
        }
    }

    @Override
    public String dumpString() {
        return "BOP " + operator;
    }
}

