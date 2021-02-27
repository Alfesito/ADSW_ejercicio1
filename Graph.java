package es.upm.dit.adsw.ej1;
import java.util.ArrayList;
import java.util.List;
/**
 * Graph= Nodes + Links 
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia 
 * @author Andres Alfaro Fernandez
 * @version 07/02/2019
 */
public class Graph {
	private List <Node> n = new ArrayList <> ();
	private List <Link> l = new ArrayList <> ();
	/**Array
	 * Constructor 
	 */
	public Graph() { }
	/**
	 * Add a node
	 * @param node
	 */
	public void addNode (Node node) {			
		n.add(node);
	}
	/**
	 * Add a link
	 * @param link
	 */
	public void addLink(Link link) {			
		l.add(link);
	}
	/**
	 * Add a bidirectional link. A to B, and B to A
	 * @param a node
	 * @param b another node
	 * @param w link weight
	 */
	public void addLink2D (java.lang.String a, java.lang.String b, int w) {
		Link l_ab = new Link(a,b,w);
		Link l_ba = new Link(b,a,w);
		l.add(l_ab);
		l.add(l_ba);
	}
	/**
	 * Getter
	 * @return list of nodes. The empty list if there are none
	 */
	public java.util.List <Node> getNodes(){  		
		List <Node> nodes = new ArrayList <> ();	//creamos una lista donde se copiaran los nodes
		for(int i=0; i<=n.size()-1; i++) {			//recorremos la lista n 
			nodes.add(n.get(i));					//copiamos sus elementos en la lista nodes
		}
		return nodes;								//return la array copiado
	}
	/**
	 * Get a node by name
	 * @param name
	 * @return node . Null if not such a node 
	 */
	public Node getNode(java.lang.String name) {
		for (int i=0; i<=n.size()-1; i++) {				//recorremos la lista n
			if(name.equals(n.get(i).getName())) {		//buscamos la condicion en la lista
				return n.get(i);						//return la posicion donde se cumple la condicion
			}
		}
		return null;
	}
	/**
	 * Get links in the graph
	 * @return list of links.The empty list if there is none
	 */
	public java.util.List <Link> getLinks(){					//igual a getNodes, pero con la clase Link
		List <Link> links = new ArrayList <> ();
		for(int i=0; i<=l.size()-1; i++) {
			links.add(l.get(i));
		}
		return links;
	}
	/**
	 * Get links from a given node
	 * @param node - source node
	 * @return list of links starting at the given node. The empty list if there is none
	 */
	public java.util.List <Link> getLinks (Node node){	
		List <Link> links = new ArrayList <> ();		
		for(int i=0; i<=l.size()-1; i++) {				
			if(node.getName().equals(l.get(i).getSrc())) {				//condicion: el param node tiene que ser igual a src(string)
				links.add(l.get(i));									//copiamos en la arraylist del metodo, cuando se cumple la condicion
			}
		}
		return links;
	}
	/**
	 * Get link from a source to a destination node
	 * @param src - source node
	 * @param dst - destination node
	 * @return link from src to dst. Null if no link 
	 */
	public Link getLink(Node src, Node dst) {					
		for(int i=0; i<=l.size()-1; i++) {				
			if((src.getName().equals(l.get(i).getSrc())) && (dst.getName().equals(l.get(i).getDst()))) {				
				return l.get(i);
			}
		}
		return null;
	}
	/**
	 * Aggregated weight of a list of nodes				//usar getLink 
	 * @param path - list of nodes
	 * @return total weight. -1 is some link is missing
	 */
	public int getWeight(java.util.List<Node> path) {
		int tweight=0;
		if(path.size()==0) {
			return -1;
		}
		for (int i=1; i<path.size();i++) {
			Node nsrc = path.get(i-1);  					
			Node ndst = path.get(i);						
			if (this.getLink(nsrc,ndst) == null) {
				return -1;
			}
			tweight += this.getLink(nsrc,ndst).getWeight();
		}
		return tweight;
	}
}