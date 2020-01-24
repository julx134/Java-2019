/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab6;
/**
 *
 * @author Jules Gammad 500874689
 */
public class Resistor {
    //creates a node array that contains 2 elements
    private Node[] nodes = new Node[2];
    //static variable that tracks all the resistor objects
    private static int resistorCount = 0;
    //instance variables tracks this objects id
    private int thisResistorID;
    //variables for the start of the node and end of the node
    private Node startNode, endNode;
    //resistance of this object
    private double resistance;
    
    public Resistor (double resistance, Node node1, Node node2) {
        
            //sets the resistance of this object
            this.resistance = resistance;
            //sets resistance id of this object w.r.t. resistor Count static variable
            thisResistorID = resistorCount;
            //increment static variable
            resistorCount++;
            
            //assign the elements of nodes with the passed object nodes
            nodes[0] = node1;
            nodes[1] = node2;
            //assign those elements into variables startNode and endNode
            startNode = nodes[0];
            endNode = nodes[1];
    }
    //returns the nodes array for this object
    public Node[] getNodes() {
        return nodes;
    }
    //returns the string representation of the object
    public String toString() {
        return ("" + "R" + thisResistorID + " " + startNode + " " + endNode + " " + this.resistance);
    }
}
