import java.io.*;
import java.util.HashMap;

public class Assembler {

    int LC = 0;
    HashMap<String, String> opcode = new HashMap<String, String>();
    HashMap<String, String> register = new HashMap<String, String>();
    HashMap<String, String> condition = new HashMap<String, String>();
    HashMap<String, String> directive = new HashMap<String, String>();
    HashMap<String, String> symbol = new HashMap<String, String>();
    HashMap<String, String> literal = new HashMap<String, String>();


    Assembler() {
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


        register.put("AREG", "1");
        register.put("BREG", "2");
        register.put("CREG", "3");
        register.put("DREG", "4");

        condition.put("LT", "1");
        condition.put("LE", "2");
        condition.put("EQ", "3");
        condition.put("GT", "4");
        condition.put("GE", "5");
        condition.put("ANY", "6");

        directive.put("START", "001");
        directive.put("END", "002");
        directive.put("DS", "003");
    }

    String searchCode(String key) {

        String finalCode = null;

        if (opcode.get(key) != null) {
            finalCode = opcode.get(key);
            return finalCode;
        }

        if (register.get(key) != null) {
            finalCode = register.get(key);
            return finalCode;
        }

        if (condition.get(key) != null) {
            finalCode = condition.get(key);
            return finalCode;
        }

        if (directive.get(key) != null) {
            finalCode = directive.get(key);
            return finalCode;
        } else
            return key;
    }

    void PassOne() throws IOException {

        FileReader f1 = null;
        FileWriter f2 = null;

        f1 = new FileReader("program.txt");
        f2 = new FileWriter("output.txt");


        BufferedReader br1 = new BufferedReader(f1);
        BufferedWriter bw1 = new BufferedWriter(f2);

        String str1;
        while ((str1 = br1.readLine()) != null) {
            String Tokens[];
            Tokens = str1.split(" ");

            System.out.println(LC + " ");
            bw1.write(LC+"		");

            for (int i = 0; i < Tokens.length; i++) {

                String code = searchCode(Tokens[i]);
                if (code == "001")
                    LC = Integer.parseInt(Tokens[1]);
   
                if (code == "003")
                    symbol.replace(Tokens[0], null, Integer.toString(LC));
                
                if (code == Tokens[i]) {
                    if (code.startsWith("=")) {
                        literal.put(code, Integer.toString(LC));
                        code = "L" + code;
                    }
                    else if(code.matches("[0-9]*")){}
                    
                    else {
                        symbol.put(code, null);
                        code = "S" + code;
                    }
                }

                System.out.print(code +"		");
                bw1.write(code +"		");
            }
            System.out.println();
            bw1.write("\n");
            LC++;
        }
        br1.close();
        bw1.close();

    }


    public static void main(String args[]) throws IOException {

        Assembler a = new Assembler();
        a.PassOne();
        
        System.out.println("Symbol Tab");
        System.out.println(a.symbol.entrySet());
        System.out.println();
        System.out.println("Literal Tab");
        System.out.println(a.literal.entrySet());
    }
}
