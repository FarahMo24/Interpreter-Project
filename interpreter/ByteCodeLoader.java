
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class ByteCodeLoader extends Object {

    // BuggeredReader
    private BufferedReader byteSource;
    // Create instance variables
    //private Program p;


    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */

    // Constructor
    public ByteCodeLoader(String file) throws IOException {

        // constructor creates a buffered reader here
        this.byteSource = new BufferedReader(new FileReader(file));
    }




    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */

    // Type Program --> see Program Class
    public Program loadCodes() {

        ArrayList<String> args = new ArrayList<>();
        Program p = new Program();
        String bLine, byteCodekey, className;
        // clear args


        // try and catch
        try{
            bLine = byteSource.readLine();

            while(bLine != null){
                // Reads in every bytecode line by line
                StringTokenizer tokenizer = new StringTokenizer(bLine);
                args.clear();
                // Takes in each token
                byteCodekey = tokenizer.nextToken();
                // Token is entered in a function to get the class name
                className = CodeTable.getClassName(byteCodekey);
                // While there are more arg
                while(tokenizer.hasMoreTokens()){
                    // add it to args
                    args.add(tokenizer.nextToken());
                }
                // Java reflection is used, gets the class object
                Class c = Class.forName("interpreter.bytecode." + className);
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance(); // handle all the Exceptions
                //
                bc.init(args);
                p.add(bc);
                // goes to the next line
                bLine = byteSource.readLine();


            }

        }catch (IOException | NoSuchMethodException | IllegalAccessException| InvocationTargetException| InstantiationException |ClassNotFoundException e){
            System.out.println("File Error" + e);
        }


        p.resolveAddrs();



        return p;
    }
}
