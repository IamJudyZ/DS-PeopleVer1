package edu.nyu.cs.ytz205_pa1;

/**
 * 
 * Programming Assignment 1
 * Person class
 * @author Judy Zhang (ytz205)
 *
 */

public class Person {

	// Constant
	private static final int maxChildren = 20;
	
	// Fields
	
    private String name;
    private Person parent1; // Biological parents
    private Person parent2;
    private int numChildren = 0;
    private Person[] children;
    
    private Person spouse;	//added data field to Person
	    

	// Constructor
	public Person(String n) {
		name = n;
		numChildren = 0;
	    children = new Person[maxChildren];
	}

	// Getters
     public String getName() { return name; }
     public Person getParent1() { return parent1;}
     public Person getParent2() { return parent2;}
     public Person[] getChildren() { return children;}
     public int getNumChildren() { return numChildren;}
     
     public Person getSpouse() { return spouse;}		//getter for Spouse
     

	// Setters

     public boolean setParent(Person q) {
    	 boolean succeed = false;
         if (q == null) {
        	 System.out.println("Parent is null");
         }
         else if (q == this) {
        	 System.out.println("A person cannot be their own parent");

         }
	     else if (parent2 != null) {
	    	 System.out.println(name + " already has two parents");
	     }
	     else if (q.numChildren >= maxChildren) {
	    	 System.out.println(q.name + " already has " + maxChildren + " children");
	     }            
	     else  {
	    	 q.children[q.numChildren] = this;
	         q.numChildren = q.numChildren + 1;
	         if (parent1 == null) {
	        	 parent1 = q;
	         }
	         else  {
	        	 parent2 = q;
	         }
	         succeed = true;
	     }
         return succeed;
     } // end SetParent

     
     /**
      * method for marrying two people
      * @param q Person to be added as spouse of .this
      * @return boolean whether the marriage was successful or not
      */
     public boolean marry(Person q) {
    	 boolean succeed = false;
    	 if (q == null) {
    		 System.out.println("Person is null");
    		 /**
    		  * there is no need to check if the owner of the method is null,
    		  * because null.marry(x) would invoke a syntax error
    		  */
    	 }
    	 else if (this.spouse != null) {
    		 System.out.println(this.name + " is already married");
    	 }
    	 else if (q.spouse != null) {
    		 System.out.println(q.name + " is already married");
    	 }
    	 else if (this.parent1 == q || this.parent2 == q) {
    		 System.out.println(q.name + " is a parent of " + this.name);
    	 }
    	 else if (q.parent1 == this || q.parent1 == this) {
    		 System.out.println(this.name + " is a parent of " + q.name);
    	 }
    	 else {
    		 this.spouse = q;
    		 q.spouse = this;
    		 succeed = true;
    	 }
    	 return succeed;
     }
     
     /**
      * divorce the Person; spouse does not to be given, it is retrieved from 
      * the data field
      * @return boolean whether the action was successful or not
      */
     public boolean divorce() {
    	 boolean succeed = false;
    	 if (this.spouse != null) {
    		 Person currentSpouse = this.getSpouse();
    		 this.spouse = null;
    		 currentSpouse.spouse = null;
    		 succeed = true;
    	 }
    	 return succeed;
     }
     
     //printers
     
     public void printSpouse() {
    	 System.out.println(this.spouse.name);
     }
     
     public void printChildren() {
    	 if (numChildren != 0) {
        	 for (int i = 0; i < this.numChildren; i++) {
            	 System.out.print(children[i].toString() + " ");
        	 }
        	 System.out.println();
    	 }
     }
     
     public String toString() {
    	 return this.name;
     }
}
