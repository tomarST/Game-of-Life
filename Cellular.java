/******************************************************************************
 *  Compilation:  javac Cellular.java
 *  Execution:    java Cellular n
 *  
 *  Simulates and prints n steps of the Rule 90 cellular automaton.
 *
 *  Sample output:  java Cellular 10
 *
 *              *         
 *             * *        
 *            *   *       
 *           * * * *      
 *          *       *     
 *         * *     * *    
 *        *   *   *   *   
 *       * * * * * * * *  
 *      *               * 
 *
 *
 *  Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 ******************************************************************************/
import java.util.*;	
public class Cellular {
   public static void main(String[] args) { 
      int n = Integer.parseInt(args[0]);
      int numCells = 2 * n;
      int r = Integer.parseInt(args[1]);
      int [][] rule = {{1,1,1},{1,1,0},{1,0,1},{1,0,0},{0,1,1},{0,1,0},{0,0,1},{0,0,0}};
      int [] output = {0,0,0,0,0,0,0,0};
      if(r>0) {
         String rules = Integer.toBinaryString(r);
         if(rules.length()<8) {
        	 while(rules.length()!=8) {
        		 rules="0"+rules;
        	 }
         }
         //System.out.println("RUles "+ rules);
         for(int i=0; i<rules.length();i++) {
        	 if(rules.charAt(i)=='1') {
        		 output[i]=1;
        	 }
        	 
         }
      }
      //System.out.println("Output "+Arrays.toString(output)); 
      

      int [] cells = new int [numCells];      // cellular automaton at time t
      int [] old   = new int [numCells];      // cellular automaton at time t-1
      for(int i =0; i<numCells;i++) {
    	  if(i==numCells/2) cells[i]=1;
    	  else cells[i]=0;	
      }
      //System.out.println(Arrays.toString(cells));
      for (int t = 1; t < n; t++) {

         // draw current row
         for (int i = 0; i < numCells; i++) {
             if(cells[i]==1) System.out.print("*");
            else         System.out.print(" ");
         }
         System.out.println("");

         // save current row
         for (int i = 0; i < numCells; i++)
            old[i] = cells[i];

         // update cells according to rule 90
         for (int i = 1; i < numCells - 1; i++) {
        	 int [] temp = {old[i-1],old[i],old[i+1]};
        	 //System.out.println(Arrays.toString(temp));
        	 if(Arrays.equals(temp,rule[0])) {
        		cells[i]=output[0];}
        	 else if(Arrays.equals(temp,rule[1])) {
            	cells[i]=output[1]; }
             else if(Arrays.equals(temp,rule[2])) {
                cells[i]=output[2];}
             else if(Arrays.equals(temp,rule[3])) {
        		 cells[i]=output[3];}
        	 else if(Arrays.equals(temp,rule[4])) {
        		 cells[i]=output[4];}
        	 else if(Arrays.equals(temp,rule[5])) {
        		 cells[i]=output[5];
        		 ///System.out.println(Arrays.toString(rule[5]));
        		 }
        	 else if(Arrays.equals(temp,rule[6])) {
            	cells[i]=output[6];}
        	 else if(Arrays.equals(temp,rule[7])) {
                cells[i]=output[7];}
        	 
         }
         //System.out.println(Arrays.toString(cells));
      }
   }
}
