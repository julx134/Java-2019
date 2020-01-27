/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Jules Gammad 500874689
 */
public class Circuit {
    //creates an arrayList for the resistors for the circuit
    private ArrayList <Resistor> resistors = new ArrayList<Resistor> ();
    
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
    
    //method to add the resistor to this object
    public void add(Resistor r) {
        resistors.add(r);
    }
    //loops through every object in the array list and print our every resistor element 
    public void toSTring() {
        for (Resistor obj : resistors) {
            System.out.println(obj.toString() + "\n");
        }
    }
}
