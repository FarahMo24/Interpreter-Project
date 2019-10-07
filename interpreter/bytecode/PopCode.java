package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {

    private int val;


    @Override
    public void init(ArrayList<String> args) {

        this.val = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //pop val amount of times
        for(int i = 0; i < val; i++){
            vm.pop();
        }
    }

    @Override
    public String dumpString() {
        return "POP " + val;
    }
}
