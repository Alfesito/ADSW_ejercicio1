package es.upm.dit.adsw.ej1;

/**
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez
 * @version 07/02/2019
 */
public class Node {
	private java.lang.String name;
	private int x;
	private int y;
	/**
	 * Constructor
	 * @param name
	 * @param x
	 * @param y
	 * @exception throws java.lang.IllegalArgumentException - if name is null or empty
	 */
	public Node (java.lang.String name, int x, int y) {
		if(name==null || name.length()==0) {
			throw new IllegalArgumentException();
		}else {
			this.name=name;
			this.x=x;
			this.y=y;
		}
	}
	/**
	 * String representation
	 */
	@Override
	public String toString() {
		return name;
	}
	/**
	 * getter
	 * @return name
	 */
	public java.lang.String getName(){
		return name;
	}
	/**
	 * getter
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * getter
	 * @return y
	 */
	public int getY() {
		return y;
	}
}	