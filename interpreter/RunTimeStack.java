package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    // Keep both private, No Getters/Setters!

    // This arrayList is used to represent the runtime stack
    // It will be an ArrayList because we'll need to access all locations
    // of the runtime stack
    private ArrayList<Integer> runTimeStack;

    // This Stack is used to record the beginning of each
    // activation record(frame) when calling functions
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    /**
     * Used for dumping the current state of the runTimeStack
     * It will print portions of the stack based on respective frame markers
     * Example [1,2,3] [4,5,6] [7,8]
     * Frame pointers would be 0,3,6,8
     * */
    public void dump(){

        // iterate through the frame pointer

        Iterator iter = framePointer.iterator(); //Integer

        // containment for frames
        int bFrame = (Integer)iter.next();
        int fFrame;

        //loop through framePointer
        for(int i = 0; i < framePointer.size();i++){
            if(iter.hasNext()){
                //  keep going if there are more frames
                fFrame = (Integer) iter.next();

            }else{
                fFrame = runTimeStack.size();
            }

            // Printing
            //System.out.println("[");
            System.out.print("[");
            for(int i1 = bFrame; i1 < fFrame; i1++){
                // get current value and print
                System.out.print(runTimeStack.get(i1));
                // remove any commas from the last item
                if(i1 != fFrame-1){
                    System.out.print(",");

                }
            }

            // close
            System.out.print("]");
            bFrame = fFrame;
        }




        // new line
        System.out.println("\n");
    }
    // Check if it's empty
    public boolean empty(){
        if (runTimeStack.isEmpty()) {

            return true;
        }
        return false;
    }

    /**
     * Returns the top of the runtime stack, but does not remove
     * @return copy of the top of the stack
     * */
    public int peek(){

        return runTimeStack.get(runTimeStack.size()-1);
    }

    /**
     * push the value i to the top of the stack.
     * @param i value to be pushed
     * @return value pushed
     * */
    public int push(int i){

        runTimeStack.add(i);
        // return i
        return i;
    }

    /**
     * Removes the top of the runtime stack
     * @return the value popped
     * */
    public int pop(){

        // Check for underflow
        if(runTimeStack.size() != 0){
            return runTimeStack.remove(runTimeStack.size()-1);
        }else {
            return 0;
        }
    }

    /**
     * Takes the top item of the run time stack, and stores
     * it into an offset starting from the current frame.
     * @param offset number of slots above current frame marker
     * @return the item just stored
     * */
    public int store(int offset){

        int pTop = this.pop();

        runTimeStack.set(framePointer.peek() + offset, pTop);
        return runTimeStack.get(offset);
    }

    /**
     * Takes a value from the run time stack that is at offset
     * from the current frame marker and pushes it onto the top
     * of the stack
     * @param offset number of slots above current frame marker
     * @return item just loaded onto the offset
     */
    public int load(int offset){

        // load in a value
        int val = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(val);
        return this.peek();

    }

    /**
     * create a new frame pointer at the index offset slot down
     * from the top of the runtime stack
     * @param offset slots down from the top of the runtime stack
     */
    public void newFrameAt(int offset){

        int frameVal = runTimeStack.size()-offset;

        if(frameVal != framePointer.lastElement()){
            framePointer.push(frameVal);
        }else{
            framePointer.add(0);
        }


    }

    /**
     * pop the current frame off the runtime stack. Also removes
     * the frame pointer value from the FramePointer Stack.
     */
    public void popFrame(){

        int val = this.peek();
        int framePop = framePointer.pop();
        //runTime
        //for(int i = j )

        // get all values out from the current frame
        for(int i = runTimeStack.size(); i > framePop; i--){
            this.pop();
        }
        this.push(val);


    }



}

