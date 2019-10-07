package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{



    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        int val;
        Scanner input = new Scanner(System.in);
        // Enter num
        System.out.print("Enter an integer: ");

//        try{
//            val = input.nextInt();
//            vm.push(val);
//        }catch(Exception e){
//            System.out.println("Invalid entry: " + e);
//        }
        // keep going for hasNext
        if(input.hasNextInt()){
            val = input.nextInt();
            vm.push(val);

        }else{
            System.out.println("Invalid entry: ");

        }
    }

    @Override
    public String dumpString() {
        return "READ ";
    }
}

