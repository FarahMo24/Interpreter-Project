package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private String label;

    @Override
    public void init(ArrayList<String> args) {

        this.label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setDump(this.label); // FIXXXXX
    }

    @Override
    public String dumpString() {
        return null;
    }
}
