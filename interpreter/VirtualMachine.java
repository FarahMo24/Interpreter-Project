package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;


import java.util.Stack;

public class VirtualMachine {

    // Use to store all variables in program
    private RunTimeStack   runStack;

    // Used to store return addresses for each called function(excluding main)
    private Stack<Integer> returnAddrs;

    // Reference to the program object where all bytecodes are stored
    private Program        program;

    // the program counter (Current bytecode being executed
    private int            pc;

    // Used to determine whether the VirtualMachine should be executing bytecodes
    private boolean        isRunning;

    // boolean
    private boolean        dump = false;



    protected VirtualMachine(Program program) {

        this.program = program;
    }

    public void executeProgram(){

        // Sample base function
        pc = 0;
        // Creats a new empty stack to store index
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;

        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            // check for dump
            if(this.dump && !(code instanceof DumpCode)){
                // print dumpString
                System.out.println(code.dumpString());
                runStack.dump();
            }

            pc++;
        }

    }

    // Peek inside the runStack
    public int peek(){
        return runStack.peek();
    }
    // push vals into runStack
    public int push(int val){
        return runStack.push(val);
    }
    // pop from runstack
    public int pop(){
        return runStack.pop();
    }
    // new frame
    public void newFrame(int offset){
        runStack.newFrameAt(offset);
    }
    // pop frame
    public void popFrame(){runStack.popFrame();}
    // load
    public int load(int offset){
        return runStack.load(offset);
    }
    // store
    public int store(int offset){
        return runStack.store(offset);
    }
    // getPc
    public int getPC(){
        return this.pc;
    }
    // setPc
    public void setPC(int addr) {
        this.pc = addr;
    }
    // Push val to returnaddr
    public void pushReturnAddrs(int addr){

        returnAddrs.push(addr);
    }
    //Halt
    public void haltProgram(){
        isRunning = false;
    }

    // pop val from returnaddr
    public int popReturnAddr(){
        return (Integer) returnAddrs.pop();
    }

    // make sure runstack is empty
    public boolean empty(){
        return runStack.empty();
    }

    public void setDump(String label){

        if(label.equals("ON")){
            dump = true;

        }
        if(label.equals("OFF")){
            dump = false;
        }
    }


}