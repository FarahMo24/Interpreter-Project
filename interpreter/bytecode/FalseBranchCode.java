package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    //instance variables
    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> args) {

        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        // FINISH THIS---------

        if(vm.pop() == 0){
            vm.setPC(address);
        }
    }

    @Override
    public String dumpString() {

        return "FALSEBRANCH" + this.label;

    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(int index){

        this.address = index-1;
    }

}

