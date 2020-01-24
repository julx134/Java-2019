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
public class Node {
    //static instance variables that keeps tracks of how many objects are created
    public static int nodeCount = 0;
    //instance variable that tracks this object's id
    private int thisNodeID;
    
    
    public Node () {
        //set the instance variable to the current nodeCount
        thisNodeID = nodeCount;
        //when an object is created increment nodeCount
        nodeCount++;
    }
    //return the node id for this object
    public String toString() {
        return ("" + thisNodeID);
    }
}
