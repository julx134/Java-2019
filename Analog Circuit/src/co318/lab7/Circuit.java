/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co318.lab7;
import java.util.ArrayList;

/**
 *
 * @author Jules Gammad 500874689
 */
public class Circuit {
    //arrayList of Objects 
    private ArrayList <Object> elements = new ArrayList<Object>();
    
    //creating a singleton instance
    private static Circuit instance = null;
       
    private Circuit() {

    }
    
    public static Circuit getInstance() {
        if (instance == null) {
            instance = new Circuit();
        }
        return instance;
    }
    
    //method to add a resistor to this circuit instance;
    public void add(Resistor r) {
        elements.add(r);
    }
    
    //method to add a voltage to this circuit instance
    public void add(VoltageSource v) {
        elements.add(v);
    }
    
    //loops through every object in the array list and print our every resistor element 
    public void getCircuit() {
        for (Object obj : elements) {
            System.out.println(obj.toString());
        }
    }
}
