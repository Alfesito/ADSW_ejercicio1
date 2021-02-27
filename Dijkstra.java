package es.upm.dit.adsw.ej1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
* @author Andres Alfaro Fernandez
* @author Daniel Gómez Campo
* @author Mateo Sarria Franco de Sarabia
* @version 07/02/2019
*/	
public class Dijkstra {
	private static final int INF = Integer.MAX_VALUE;
	private final Graph graph;
	private final Node src;
	private final Map<Node, Node> nAnterior;
	private final Map<Node, Integer> dist;	
	
	/**
	 * Constructor. Calculates the minimal path to every other node in the graph	
	 * @param graph_
	 * @param src_
	 */
	public Dijkstra(Graph graph, Node src) {
		
		this.nAnterior=new HashMap<>();
		this.dist=new HashMap<>();
		this.graph = graph;
		this.src = src;
		
		if(graph!=null) {
		Set<Node>noVisit = getAcces(src); 
		
		for(Node node: noVisit) {
			this.dist.put(node, INF);
		}
		
		this.dist.put(src,  0);
		
		while (!noVisit.isEmpty()){
			Node node = getMCerc(noVisit);
			noVisit.remove(node);
			int d = dist.get(node);
			List<Link> links = graph.getLinks(node);
			for(Link link: links) {
				Node next = graph.getNode(link.getDst());
				int dn = d + link.getWeight();
		
				if(dn < this.dist.get(next)) {
					this.dist.put(next,dn);
					this.nAnterior.put(next,node);
				}
			}
		}
		}else if (graph == null) {
			throw new NullPointerException();			
		}	
	}
	
	/**
	 * Shortest path (minimal weight)
	 * @param dst
	 * @return
	 */
	public java.util.List<Node> getPath(Node dst){
		List<Node> path = new ArrayList<>();
		if(dst.getName()!=null||dst.getName().length()!=0) {
		path.add(dst);
		}
		Node n = dst;
		int t=0;

		while (src!=n) {				
			n =nAnterior.get(n);
			if(n == null) {
				return null;
			}
			path.add(t, n);
		}
		return path;
	}
	
	
	private Node getMCerc(Set<Node> noVisit) {
		int distMin = Integer.MAX_VALUE;
		Node MCerc=null;
		
		for ( Node n : noVisit) {
			int d = dist.get(n);
			if (distMin>d) {
				distMin = d;
				MCerc = n;			
			}
		}
		return MCerc;
	}
	
	private Set<Node> getAcces(Node node) {
		List<Node> cola = new ArrayList<>();
		Set<Node> set = new HashSet<>();
		cola.add(node);
		
		while(true) {
			Node prox;
			do {
				if (cola.isEmpty()) {
					return set;
				}
				prox = cola.remove(0);
			} while (set.contains(prox));
			set.add(prox);
			
			for (Link link : graph.getLinks(prox)) {
				cola.add(graph.getNode(link.getDst()));
			}
		}	
	}
	
}
