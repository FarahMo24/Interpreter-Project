package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{



    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {

        // Prints the top of the RunTimeStack
        System.out.println("WRITE\n" + vm.peek());

    }

    @Override
    public String dumpString() {
        return "WRITE";
    }
}

