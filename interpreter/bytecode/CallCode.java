package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{

    //instance variables
    private String label;
    private int address;
    private int topElement;


    @Override
    public void init(ArrayList<String> args) {
        // pass in the label
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        //vm.pushReturnAddrs(vm.getPC());

        vm.pushReturnAddrs(vm.getPC()); // return address

        vm.setPC(this.address);

        //fix this if-statement
        if(vm.empty()){
            // set it to -1
            topElement = -1;

        }else{
            topElement = vm.peek();
        }
    }

    @Override
    public String dumpString() {

        String id;
        int index = label.indexOf("<");//check index

        if(index >= 0 ){
            id = label.substring(0,index);
        }else{
            id = label;
        }

        String val;

        if(topElement == -1){
            val = "CALL " + label + "   " + id + "()";
        }else{
            val = "CALL " + label + "   " + id + "(" + topElement + ")";
        }
        return val;
    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(int index){ // FIXXXXXXXXX-----------

        this.address = index-1;
    }
}

