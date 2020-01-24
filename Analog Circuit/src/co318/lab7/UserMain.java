/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co318.lab7;

/**
 *
 * @author jules
 */

//imports Scanner library
import java.util.ArrayList;
import java.util.Scanner;


public class UserMain {
    //initializes scanner
    private static boolean voltageSource, resistor;
    //creates an arrayList for the resistors for the circuit
    private static ArrayList <Node> nodes = new ArrayList<Node> ();
    
    
    
    public static void main (String[] args) {
        //Scanner initialization
        Scanner in = new Scanner(System.in);
        //local var for string input from user
        String userInput;
        
        System.out.println("Welcome to the program!");
        //run's prompt/intializing methods
        startPrompt();
        userChoose();
        //do while to keep re-iterating until user says end
        do {
            //prompts user again
            System.out.println("Would you like to continue? (\"yes\" - to continue, \"spice\" - for spice output, \"end\" - to end program");
            userInput = in.nextLine();
            
            //runs method to choos and add element
            if (userInput.equalsIgnoreCase("yes")) {
            //runs userChoose method that prompts user for both resistance or voltage source
            //also linked to a method that adds the respective resistance/voltage source
            userChoose();
            }
            //runs spice method
            if(userInput.equalsIgnoreCase("spice")) {
            spice();
            }   
            
        }while(!userInput.equalsIgnoreCase("end"));
        
        //once outside of the loop the end method will run'
        end();
        
    }
    
    public static void end () {
        System.out.println("All Done");
    }
    
    public static void spice() {
        //calls the circuit instance
        Circuit cir = Circuit.getInstance();
        //prints circuit components
        cir.getCircuit();       
    }
    
    public static void startPrompt() {
        //local variables so to prevent static/non-static compile error
        Scanner in = new Scanner(System.in);
        int numNode;
        
        do {
             System.out.println("How many nodes would you like in your circuit?");
             numNode = in.nextInt();
        }while (numNode <= 0); 
        
        //adds n instances of nodes to the circuit
        for (int i = 0; i < numNode; i++) {
         nodes.add(new Node());
        }
    }
    
    public static void userChoose() {
        //set boolean values to false - no choice between voltageSource or resistor
        voltageSource = false;
        resistor = false;
        
        //local variables so to prevent static/non-static compile error
        Scanner in = new Scanner(System.in);
        String userInput;
        //prompt
        System.out.println("Would you like to add a resistor or a voltage source?");
        do {
            //assigns userInput value
            userInput = in.nextLine();
            //if the input does not match the break-loop condition, output code
            if (!userInput.equalsIgnoreCase("r") && !userInput.equalsIgnoreCase("v")) {
            System.out.println("Sorry that is an incorrect input. Try again");    
            System.out.println("Would you like to add a resistor or a voltage source?");
            }
            
        }while (!userInput.equalsIgnoreCase("r") && !userInput.equalsIgnoreCase("v"));
        
        //if statements to see which element user chooses
        if (userInput.equalsIgnoreCase("r")) {
            voltageSource = false;
            resistor = true;
            addElement();
        }else if (userInput.equalsIgnoreCase("v")){
            resistor = false;
            voltageSource = true;
            addElement();
        }
    }
    
    public static void addElement() {
        //local variables so to prevent static/non-static compile error
        Scanner in = new Scanner(System.in);
        String userInput;
        Node nodeStart = null;
        Node nodeEnd = null;
        
        
        //if the resistor is the one user chooses
        if (resistor) {
            System.out.println("Values for this resistor:");
            System.out.println("Start Node --> ");
            int startNode = in.nextInt();
            System.out.println("End Node --> ");
            int endNode = in.nextInt();
            System.out.println("Resistance Magnitude --> ");
            double resistance = in.nextDouble();
            
            for(Node node: nodes) {
                if (startNode == node.getNodeID())
                    nodeStart = node;
                if (endNode == node.getNodeID()) {
                    nodeEnd = node;
                }  
            }    
           new Resistor(resistance, nodeStart, nodeEnd);
            
        }else { //same code but for voltage sources
            System.out.println("Values for this voltage source:");
            System.out.println("Start Node --> ");
            int startNode = in.nextInt();
            System.out.println("End Node --> ");
            int endNode = in.nextInt();
            System.out.println("Voltage Source Magnitude --> ");
            double voltage = in.nextDouble();
            
            for(Node node: nodes) {
                if (startNode == node.getNodeID())
                    nodeStart = node;
                if (endNode == node.getNodeID()) {
                    nodeEnd = node;
                }  
            }    
            new VoltageSource(voltage, nodeStart, nodeEnd);
        }
    }

}
