package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    // Type ByteCode
    private ArrayList<ByteCode> program;
    // Hashmap stores addresses as strings and index as ints
    private static HashMap<String, Integer> addr = new HashMap<String, Integer>();


    public Program() {

        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {

        return this.program.get(pc);
    }

    public void add(ByteCode bc){

        if(bc instanceof LabelCode){
            LabelCode label = (LabelCode) bc;
            addr.put(label.getLabel(), program.size());

        }

        // add bytecode
        program.add(bc);
    }


    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {

        int address;


        for(int i = 0; i < program.size(); i++){
            // instanceof tests whether the object is an instance of the specified type
            if(program.get(i) instanceof CallCode){
                CallCode callC = (CallCode) getCode(i);
                address = addr.get(callC.getLabel());
                callC.setLabel(address);
            }

            else if(program.get(i) instanceof FalseBranchCode){
                FalseBranchCode falseB = (FalseBranchCode) getCode(i);
                address = addr.get(falseB.getLabel());
                falseB.setLabel(address);

            }
            else if(program.get(i) instanceof GotoCode){
                GotoCode gotoC = (GotoCode) getCode(i);
                address = addr.get(gotoC.getLabel());
                gotoC.setLabel(address);
            }
        }

    }






}
