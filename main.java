import java.util.Scanner;

public class main{
    public static void main(String[] args){
        //initializing scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to power rule calculator!\nEnter a single term (in terms of x) to do the power rule on.\n------------------------------------------------------------");
        String term = input.nextLine();

        while(!term.equals("exit")){
            String newTerm = "";

            //constant
            if(!hasVariable(term)){
                newTerm += "The derivative of " + term + " is 0";
                System.out.println(newTerm);

            //variable and nothing else
            }else if(term.equals("x")){
                newTerm += "The derivative of " + term + " is 1";
                System.out.println(newTerm);

            //constant multiple
            }else if(hasConstantMultiple(term)){
                newTerm += term.substring(0, term.indexOf("x"));
                System.out.println("The derivative of " + term + " is " + newTerm);

            //power rule
            }else if(hasCoeffAndExp(term)){
                //case 1: has coefficient
                if(term.indexOf("x") != 0){
                    int coefficient = Integer.parseInt(term.substring(0, term.indexOf("x")));
                    int exponent = Integer.parseInt(term.substring(term.indexOf("^") + 1, term.length()));
                    int newCoefficient = coefficient * exponent;
                    int newExponent = exponent - 1;

                    if(newExponent == 1){
                        newTerm += newCoefficient + "x";
                        System.out.println("The derivative of " + term + " is " + newTerm);
                    }else{
                        newTerm += newCoefficient + "x^" + newExponent;
                        System.out.println("The derivative of " + term + " is " + newTerm);
                    }
                //case 2: does not have coefficient (coefficient is 1)
                }else if(term.indexOf('x') == 0){
                    int exponent = Integer.parseInt(term.substring(term.indexOf("^") + 1, term.length()));
                    int newExponent = exponent - 1;

                    if(newExponent == 1){
                        newTerm += exponent + "x";
                        System.out.println("The derivative of " + term + " is " + newTerm);
                    }else{
                        newTerm += exponent + "x^" + newExponent;
                        System.out.println("The derivative of " + term + " is " + newTerm);
                    }
                }
            }
            
            term = input.nextLine();
        }
    }

    //method that returns true if term contains a variable x, false if not
    public static boolean hasVariable(String testTerm){
        if(testTerm.contains("x")){
            return true;
        }
        return false;
    }

    //method that returns true if term contains an exponent (denoted by ^), false if not
    public static boolean hasExponent(String testTerm){
        if(testTerm.contains("^")){
            return true;
        }
        return false;
    }

    //method that returns true if the term is a constant multiple, false if not
    public static boolean hasConstantMultiple(String testTerm){
        if(hasVariable(testTerm) && !hasExponent(testTerm)){
            return true;
        }
        return false;
    }

    //method that returns true if term contains an exponent AND a coefficient 
    public static boolean hasCoeffAndExp(String testTerm){
        if(hasVariable(testTerm) && hasExponent(testTerm)){
            return true;
        }
        return false;
    }
}

    //method that returns true if term contains an exponent (denoted by ^), false if not
    public static boolean hasExponent(String testTerm){
        if(testTerm.contains("^")){
            return true;
        }
        return false;
    }
}
