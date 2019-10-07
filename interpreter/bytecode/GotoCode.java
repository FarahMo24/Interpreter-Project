package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {

    //instance variables
    private String label;
    private int address; // need the address for execute

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        // FINISH THIS---------
        vm.setPC(address);
    }

    @Override
    public String dumpString() {
        return "GOTO" + this.label;
    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(int index){
        this.address = index-1;
    }


}
