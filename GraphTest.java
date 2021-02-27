package es.upm.dit.adsw.ej1;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Pruebas básicas de la clase Graph.
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez
 * @version 14/02/2019
 */
public class GraphTest {
	
    private Graph graph;	//crea un objeto graph
    private Graph graphvacia;	//se crea para la condicion de null de getLinks()
    private Node N0;									//crea varios nodos
    private Node N1;
    private Node N2;
    private Node N3;
    private Node N4;
    private Node N5;
   
    public GraphTest() {
    	
        graph = new Graph();	//graph=null
        graphvacia=new Graph();		//para getLinks()
        N0 = new Node("0", 0, 0);						//define los nodos creados anteriormente
        N1 = new Node("1", 0, 0);
        N2 = new Node("2", 0, 0);
        N3 = new Node("3", 0, 0);
        N4 = new Node("4", 0, 0);
        N5 = new Node("5", 0, 0);
        graph.addNode(N0);								//añade los nodos definidos a graph
        graph.addNode(N1);								//verificamos que mth addNode() funciona
        graph.addNode(N2);
        graph.addNode(N3);
        graph.addNode(N4);
        graph.addNode(N5);
        graph.addLink(new Link("0", "1", 1));			//define unos links
        graph.addLink(new Link("0", "5", 2));			//añade los links a graph
        graph.addLink(new Link("1", "2", 3));			//teniendo en cuenta los 5 nodos 
        graph.addLink(new Link("1", "3", 4));
        graph.addLink(new Link("1", "4", 5));
        graph.addLink(new Link("2", "0", 6));
        graph.addLink(new Link("3", "4", 7));
        graph.addLink2D("4", "2", 8);			//2dirrec. link para dos nodos(4,2 y 2,4)
        
    }

    @Test
    public void test00() {									//verificamos getNodes()
        Set<Node> expected = new HashSet<>(Arrays.asList(N0, N1, N2, N3, N4, N5));		
        Set<Node> actual = new HashSet<>(graph.getNodes());			
        assertEquals(expected, actual);
    }
    
    @Test (expected = IllegalArgumentException.class)		//verificamos excepciones de getNodes()
    public void test01() {
    	Node N6=new Node("", 0, 0);  	
    	Set<Node> expected = new HashSet<>(Arrays.asList(N0, N1, N2, N3, N4, N5, N6));		
        Set<Node> actual = new HashSet<>(graph.getNodes());			
        assertEquals(expected, actual);
    }
    
    @Test (expected = IllegalArgumentException.class)		//verificamos excepciones de getNodes()
    public void test02() {
    	Node N6=new Node(null, 0, 0);   	
    	Set<Node> expected = new HashSet<>(Arrays.asList(N0, N1, N2, N3, N4, N5, N6));		
        Set<Node> actual = new HashSet<>(graph.getNodes());			
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {									//verificamos getLinks()
        Link link01 = graph.getLink(N0, N1);				//creamos links
        Link link05 = graph.getLink(N0, N5);				//obtenemos el link entre dos nodos
        Link link12 = graph.getLink(N1, N2);
        Link link13 = graph.getLink(N1, N3);
        Link link14 = graph.getLink(N1, N4);
        Link link20 = graph.getLink(N2, N0);
        Link link34 = graph.getLink(N3, N4);
        Link link42 = graph.getLink(N4, N2);
        Link link24 = graph.getLink(N2, N4);

        Set <Link> expected = new HashSet<>(Arrays.asList(	//creamos un conjunto con los links
                link01, link05, link12, link13, link14,
                link20, link34, link42, link24
        ));
        Set<Link> actual = new HashSet<>(graph.getLinks());	//verificamos getLinks()
        assertEquals(expected, actual);
    }
    
    @Test
    public void test11() {									//array vacia
    	List <Link> expected = new ArrayList<>(Arrays.asList());		
        List <Link> actual = new ArrayList<>(graphvacia.getLinks());
        assertEquals(expected, actual);
    }
    
    @Test (expected =IllegalArgumentException.class)
    public void test12() {						//verificamos las excepciones getLinks()
    	Node N6=new Node(null, 0, 0);
    	Node N7=new Node("", 0, 0);
    	Link link01 = graph.getLink(N0, N1);				//creamos links
        Link link05 = graph.getLink(N0, N5);				//obtenemos el link entre dos nodos
        Link link12 = graph.getLink(N1, N2);
        Link link13 = graph.getLink(N1, N3);
        Link link14 = graph.getLink(N1, N4);
        Link link20 = graph.getLink(N2, N0);
        Link link34 = graph.getLink(N3, N4);
        Link link42 = graph.getLink(N4, N2);
        Link link24 = graph.getLink(N2, N4);
        Link link64 = graph.getLink(N6, N4);
        Link link17 = graph.getLink(N1, N7);

        Set <Link> expected = new HashSet<>(Arrays.asList(	//creamos un conjunto con los links
                link01, link05, link12, link13, link14,
                link20, link34, link42, link24, link64,
                link17
        ));
        Set<Link> actual = new HashSet<>(graph.getLinks());	//conjunto obtenido con el mth getLinks()
        assertEquals(expected, actual);	
    }

    @Test
    public void test20() {								//prueba getNode()
        assertEquals(N0, graph.getNode("0"));
        assertEquals(N1, graph.getNode("1"));
        assertEquals(N2, graph.getNode("2"));
        assertEquals(N3, graph.getNode("3"));
        assertEquals(N4, graph.getNode("4"));
        assertEquals(N5, graph.getNode("5"));
        assertEquals(null, graph.getNode("abc"));
    }
    
    @Test (expected = IllegalArgumentException.class)	//excepciones prueba getNode()
    public void test21() {
    	Node N6=new Node(null, 0, 0);
    	Node N7=new Node("", 0, 0);
    	assertEquals(N6, graph.getNode(null));
    	assertEquals(N7, graph.getNode(""));
    }

    @Test
    public void test30() {							//pruebas getLink(src, dst)
        Link link01 = graph.getLink(N0, N1);
        assertEquals("0", link01.getSrc());
        assertEquals("1", link01.getDst());
        assertEquals(1, link01.getWeight());

        Link link10 = graph.getLink(N1, N0);
        assertNull(link10);

        Link link34 = graph.getLink(N3, N4);
        assertEquals("3", link34.getSrc());
        assertEquals("4", link34.getDst());
        assertEquals(7, link34.getWeight());
        
        assertEquals(null, graph.getLink(N1, N5));     //NULL cuando no se encuentra un link para los nodos
    }
    
    @Test (expected= IllegalArgumentException.class)
    public void test31() {							//pruebas excepciones getLink(src, dst)
    	Node N6=new Node(null, 0, 0);
    	Link link64 = graph.getLink(N6, N4);
        assertEquals(null, link64.getSrc());
        assertEquals("4", link64.getDst());
        assertEquals(0, link64.getWeight());

        Node N7=new Node("", 0, 0);
        Link link17 = graph.getLink(N1, N7);
        assertEquals("1", link17.getSrc());
        assertEquals("", link17.getDst());
        assertEquals(0, link17.getWeight());
    }

    @Test
    public void test40() {							//prueba getLinks(node)
        Link link01 = graph.getLink(N0, N1);
        Link link05 = graph.getLink(N0, N5);
        Set<Link> expected0 = new HashSet<>(Arrays.asList(link01, link05));
        Set<Link> actual0 = new HashSet<>(graph.getLinks(N0));
        assertEquals(expected0, actual0);

        Link link34 = graph.getLink(N3, N4);
        List<Link> expected3 = Arrays.asList(link34);
        assertEquals(expected3, graph.getLinks(N3));
    }
    
    @Test
    public void test41() {
        Node N6=new Node("6", 0, 0);						
        List <Link> expected1 = new ArrayList<>(Arrays.asList());
        assertEquals(expected1, graph.getLinks(N6));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test42() {							//prueba excepciones getLinks(node)
    	Node N6=new Node(null, 0, 0);
    	Node N7=new Node("", 0, 0);
        Link link61 = graph.getLink(N6, N1);
        Link link67 = graph.getLink(N6, N7);
        Set<Link> expected0 = new HashSet<>(Arrays.asList(link61, link67));
        Set<Link> actual0 = new HashSet<>(graph.getLinks(N6));
        assertEquals(expected0, actual0);

        Link link37 = graph.getLink(N3, N7);
        List<Link> expected3 = Arrays.asList(link37);
        assertEquals(expected3, graph.getLinks(N3));
    }
    
//getWeight()
    @Test////
    public void test50() {			//pruebas getWeight()
        assertEquals(-1, graph.getWeight(Arrays.asList()));
        assertEquals(0, graph.getWeight(Arrays.asList(N0)));
        assertEquals(1, graph.getWeight(Arrays.asList(N0, N1)));
        assertEquals(1 + 3, graph.getWeight(Arrays.asList(N0, N1, N2)));
        assertEquals(1 + 3 + 6, graph.getWeight(Arrays.asList(N0, N1, N2, N0)));
        assertEquals(-1, graph.getWeight(Arrays.asList(N0, N2, N3)));
    }
    
    @Test (expected = IllegalArgumentException.class)	//pruebas con excepcion getWeight()
    public void test51() {
    	Node N6=new Node(null, 0, 0);
    	Node N7=new Node("", 0, 0);
    	assertEquals(-1, graph.getWeight(Arrays.asList(N6)));
    	assertEquals(-1, graph.getWeight(Arrays.asList(N7)));
    	assertEquals(-1, graph.getWeight(Arrays.asList(N6, N2, N7)));   	
    }

    @Test////
    public void test60() {			
        Link link24 = graph.getLink(N2, N4);
        assertEquals("2", link24.getSrc());
        assertEquals("4", link24.getDst());
        assertEquals(8, link24.getWeight());
        Link link42 = graph.getLink(N4, N2);
        assertEquals("4", link42.getSrc());
        assertEquals("2", link42.getDst());
        assertEquals(8, link42.getWeight());
        assertEquals(8 + 8, graph.getWeight(Arrays.asList(N2, N4, N2)));//
    } 
}