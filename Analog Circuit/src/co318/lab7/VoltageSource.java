/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co318.lab7;
/**
 *
 * @author Jules Gammad 500874689
 */
public class VoltageSource {
    //creates a node array that contains 2 elements
    private Node[] nodes = new Node[2];
    //static variable that tracks all the voltageSources objects
    private static int voltageCount = 0;
    //instance variables tracks this objects id
    private int thisVoltageID;
    //variables for the start of the node and end of the node
    private Node startNode, endNode;
    //voltage magnitude of this object
    private double voltageMagnitude;
    //calls the circuit instance
    Circuit cir = Circuit.getInstance();

    public VoltageSource (double voltage, Node node1, Node node2) {
        //series of throw exceptions to throw at user
        //voltage magnitude has to be more than zero, otherwise throw an exception
        if (voltage <= 0.0) {
            throw new IllegalArgumentException("Resistance cannot be less than or equal to zero");
        }
        //nodes cannot be empty, otherwise thrown an exception
        else if (node1 == null || node2 == null) {
            throw new IllegalArgumentException("The node(s) cannot be null");
        }
        //no start nodes and end nodes cannot be the same (short-circuit), throw an exception
        else if (node1.equals(node2)) {
            throw new IllegalArgumentException("The nodes cannot be the same");
        }
        else {
            //sets the voltageMagnitude of this object
            this.voltageMagnitude = voltage;
            //sets voltage id of this object w.r.t. resistor Count static variable
            thisVoltageID = voltageCount;
            //increment static variable
            voltageCount++;
            
            //assign the elements of nodes with the passed object nodes
            nodes[0] = node1;
            nodes[1] = node2;
            //assign those elements into variables startNode and endNode
            startNode = nodes[0];
            endNode = nodes[1];
            
            //checks to see if the polarization is negative or not
            if (startNode.getNodeID() < endNode.getNodeID()) {
                voltageMagnitude = -1.0*voltageMagnitude;
            }
            
            //adds any new instance of voltageSource to the circuit
            cir.add(this);
        }
        
    }
    //returns the nodes array for this object
    public Node[] getNodes() {
        return nodes;
    }
    //returns the string representation of the object
    public String toString() {
        return ("" + "V" + (thisVoltageID+1) + " " + startNode + " " + endNode + " " + "DC" + " " + this.voltageMagnitude);
    }
}
