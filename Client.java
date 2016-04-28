package calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client { 
    public static void main(String args[]) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        Interface obj = (Interface) registry.lookup("Server");
        Scanner scan = new Scanner(System.in);
        Double a, b;
        String operation;
        char operatorNumber;
        a = null; b = null;
        boolean repeat=true;
        
        while(repeat){
            System.out.println("Alegeti o operatie:"); 
            System.out.println(" 0. Nimic..."); 
            System.out.println(" 1. Adunare"); 
            System.out.println(" 2. Scadere"); 
            System.out.println(" 3. Inmultire"); 
            System.out.println(" 4. Impartire"); 
            System.out.println(" 5. Inversare"); 
            System.out.println(" 6. Ridicare la putere"); 
            System.out.println(" 7. Factorial"); 
            System.out.println(" 8. Radacina patrata"); 
            System.out.println(" 9. Sterge numarul memorat"); 
            try {
                if(!scan.hasNext("0") &&
                   !scan.hasNext("1") &&
                   !scan.hasNext("2") &&
                   !scan.hasNext("3") &&
                   !scan.hasNext("4") &&
                   !scan.hasNext("5") &&
                   !scan.hasNext("6") &&
                   !scan.hasNext("7") &&
                   !scan.hasNext("8") &&
                   !scan.hasNext("9"))
                    throw new Exception("You must insert an number from 0 to 8 !");
            } catch(Exception X) {
                X.printStackTrace();
            }
            operation = scan.next();
            operatorNumber = operation.charAt(0);

            if(operatorNumber==0){
                repeat=false;
                break;
                }
            if(operatorNumber != '9'){
                if(operatorNumber == '5' || operatorNumber == '7' || operatorNumber == '8'){
                    /** Trying to get the number *\
                    \***********************************/
                    if(a == null){
                        try {
                            if(!scan.hasNextDouble())
                                throw new Exception("You must insert a double.");
                        } catch(Exception X) {
                            X.printStackTrace();
                        }
                        a = scan.nextDouble();
                    }
                } else {
                    /** Trying to get the first number *\
                    \***********************************/
                    if(a == null){
                        try {
                            if(!scan.hasNextDouble())
                                throw new Exception("You must insert a double.");
                        } catch(Exception X) {
                            X.printStackTrace();
                        }
                        a = scan.nextDouble();
                    }

                    /***********************************/
                    /** Trying to get the second number *\
                    \************************************/
                    try {
                        if(!scan.hasNextDouble())
                            throw new Exception("You must insert a double.");
                    } catch(Exception X) {
                        X.printStackTrace();
                    }
                    b = scan.nextDouble();
                    /************************************/
                }
            }
            
            /** Trying to calculate *\
            \************************/
            try {
                switch(operatorNumber){
                    case '1':{
                        a = obj.add(a,b);
                        break;
                    }
                    case '2':{
                        a = obj.subtract(a,b); 
                        break;
                    }
                    case '3':{
                        a=obj.multiply(a,b); 
                        break;
                    }
                    case '4':{
                        a = obj.divide(a,b); 
                        break;
                    }
                    case '5':{
                        a = obj.invert(a); 
                        break;
                    }
                    case '6':{
                        a = obj.power(a,b); 
                        break;
                    }
                    case '7':{
                        a = obj.factorial(a); 
                        break;
                    }
                    case '8':{
                        a = obj.sqareroot(a); 
                        break;
                    }
                    case '9':{
                        a = null;
                        break;
                    }
                }
            } catch (Exception X) {
                X.printStackTrace();
            }
            if(a==null)
                System.out.println(0);
            else
                System.out.println(a); 
            /************************/
            
        }
    }
}
