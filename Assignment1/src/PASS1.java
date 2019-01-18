import java.util.HashMap;
import java.io.*;
public class PassOne {

    public static void main(String args[]) 
{
	HashMap <String, String> opcode = new HashMap<String,String>();

		opcode.put("STOP", "00");
		opcode.put("ADD", "01");
		opcode.put("SUB", "02");
		opcode.put("MULT", "03");
		opcode.put("MOVER", "04");
		opcode.put("MOVEM", "05");
		opcode.put("COMP", "06");
		opcode.put("BC", "07");
		opcode.put("DIV", "08");
		opcode.put("READ", "09");
		opcode.put("PRINT", "10");


if (!opcode.isEmpty()) 
        { 
            System.out.println("HashMap opcode is notempty"); 
  
            // Accessing the contents of HashMap through Keys 
            System.out.println("OPCODE : " + opcode.get("STOP")); 
            System.out.println("OPCODE : " + opcode.get("ADD")); 
            System.out.println("OPCODE : " + opcode.get("SUB")); 
            System.out.println("OPCODE : " + opcode.get("MULT"));
	    System.out.println("OPCODE : " + opcode.get("MOVER"));
	    System.out.println("OPCODE : " + opcode.get("MOVEM"));
	    System.out.println("OPCODE : " + opcode.get("COMP"));
	    System.out.println("OPCODE : " + opcode.get("BC"));
	    System.out.println("OPCODE : " + opcode.get("DIV"));
	    System.out.println("OPCODE : " + opcode.get("READ"));
	    System.out.println("OPCODE : " + opcode.get("PRINT"));
	     
  
            // size() method prints the size of HashMap. 
            System.out.println("Size Of HashMap : " + opcode.size()); 
        } 
}
}
