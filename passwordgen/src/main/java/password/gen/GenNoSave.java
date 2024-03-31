package Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class GenNoSave {
    public static final char[] simbolos = {
        '!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', 
        '?', '@', '[', ']', '^', '_', '{', '|', '}', '¡', '¸', '¿' };

    
    public static void main(String[] a) {
        try {
            String result = genPass(); // Llamada al método main que retorna un String
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /**
     * @param name
     * @return
     * @throws Exception
     */
    
     
    public static String genPass() throws Exception {
        // Declaracion de variables
        char symbol;
        int num;
        int type;

        SecureRandom length = new SecureRandom();
        // Genera cada vez una semilla distinta
        length.setSeed(length.generateSeed(20));
        // Creacion de la longitud de la contraseña
        num = length.nextInt((18-12) + 1) + 12;
        // Creacion de la pass
        char[] arrayPass = new char[num];
        
        for (int i = 0; i < num; i++){
            type = length.nextInt(3);
            switch (type) {
                case 0:
                    symbol = getRandomSymbol();
                    arrayPass[i] = symbol;
                    break;
                case 1:
                    symbol = getRandomLetter();
                    arrayPass[i] = symbol;
                    break;
                case 2:
                    symbol = getRandomNumber();
                    arrayPass[i] = symbol;       
            }
        }

        // Convert char array to String
        String pass = new String(arrayPass);
        return(pass);
    }

    // Gen random number
    public static char getRandomNumber(){
        SecureRandom rNumber = new SecureRandom();
        rNumber.setSeed(rNumber.generateSeed(20));
        int numberRandom = rNumber.nextInt((57-48) + 1) + 48;
        return (char)numberRandom;
    }
    
    // Gen random symbol
    public static char getRandomSymbol(){
        SecureRandom rSymbol = new SecureRandom();
        rSymbol.setSeed(rSymbol.generateSeed(20));
        int symbolRandom = rSymbol.nextInt(simbolos.length);
        return simbolos[symbolRandom];
    }

    // Gen random letter minus or mayus
    public static char getRandomLetter(){
        int letterRandom;
        SecureRandom rLetter = new SecureRandom();
        rLetter.setSeed(rLetter.generateSeed(20));
        int randomType = rLetter.nextInt(2);
        if (randomType == 0){
            letterRandom = rLetter.nextInt((90-65) + 1) + 65;
        } else{
            letterRandom = rLetter.nextInt((122-97) + 1) + 97;
        } 
        return (char)letterRandom;
    }
}

