package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    // instance vars
    int val;
    String id;


    @Override
    public void init(ArrayList<String> args) {

        val = Integer.parseInt(args.get(0));
        if(args.size() > 1 ){
            id = args.get(1);
        }else{
            id="";
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        // push literal vals
        if(id == ""){
            vm.push(val);
        }else{
            // variable names
            vm.push(0);
        }
    }

    @Override
    public String dumpString() {


        if(id == ""){
            return "LIT " + val;
        }else{
            return "LIT " + val + " " + id + " int " + id;
        }

    } // ------------------------------------------
}