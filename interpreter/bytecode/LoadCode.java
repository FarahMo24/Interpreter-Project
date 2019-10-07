package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{

    private int val;
    private String id;


    @Override
    public void init(ArrayList<String> args) {
        // remove initial element
        val = Integer.parseInt(args.remove(0));
        // check if empty
        if(args.isEmpty()){
            id = "";
        }else{
            id = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.load(val);
    }

    @Override
    public String dumpString() {
        return "LOAD " + val + " " + id;
    }
}

