package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private int val;
    private String id;
    private int topElement;



    @Override
    public void init(ArrayList<String> args) {

        this.val = Integer.parseInt(args.remove(0));

        if(args.isEmpty()){
            id = "";

        }else{
            id = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        // top element form runTimeStack
        this.topElement = vm.peek();
        vm.store(val);
    }

    @Override
    public String dumpString() {

        return "STORE " + val + " " + id;

    }
}

