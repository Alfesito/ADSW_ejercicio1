package es.upm.dit.adsw.ej1;
/**
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez
 * @version 07/02/2019
 */
public class Link {
	private java.lang.String src;
	private java.lang.String dst;
	private int weight;
	/**
	 * Constructor
	 * @param src - Source node name
	 * @param dst - Destination node name
	 * @param weight - Transit delay, or a line capacity, or ...
	 * @exception java.lang.IllegalArgumentException - if src or dst is null, of weight is less than 0
	 */
	public Link (java.lang.String src, java.lang.String dst,int weight) {
		if (src==null || dst==null) {
			throw new IllegalArgumentException();
		}
		else if (weight<0) {
			throw new IllegalArgumentException();
		} else {
			this.src=src;
			this.dst=dst;
			this.weight=weight;
		}
	}
	/**
	 * Getter
	 * @return src
	 */
	public java.lang.String getSrc(){
		return src;
	}
	/**
	 * Getter
	 * @return dst
	 */
	public java.lang.String getDst(){
		return dst;
	}
	/**
	 * Getter
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * String representation
	 */
	@Override
	public String toString() {
		return "Link [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
	}
	
	
}