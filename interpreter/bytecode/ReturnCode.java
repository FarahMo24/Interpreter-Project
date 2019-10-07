package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{

    private String label;
    private int val;

    @Override
    public void init(ArrayList<String> args) {

        if (args.isEmpty()) {
            label = "";
        } else {
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setPC(vm.popReturnAddr());
        vm.popFrame();
        val = vm.peek();
    }

    @Override
    public String dumpString() {

        String print;

        if (label == "") {
            print = "RETURN"; //if no label, just return "RETURN"
        } else {
            String str;
            int index = label.indexOf("<");

            if (index >= 0) {
                str = label.substring(0, index);
            } else {
                str = label;
            }
            print = "RETURN " + label + " exit " + str + ": " + val;
        }
        return print;

    }
}

