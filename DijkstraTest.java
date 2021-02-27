package es.upm.dit.adsw.ej1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Pruebas del algoritmo de Dijkstra.
 * @author Damiel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez
 * @version 18/02/2019
 */
public class DijkstraTest {
    private Graph graph;
    private Node A;
    private Node B;
    private Node C;
    private Node D;//


    @Before
    public void setup() {
        graph = new Graph();
        A = new Node("a", 0, 0);
        B = new Node("b", 0, 0);
        C = new Node("c", 0, 0);
        D = new Node("d", 0, 0);
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addLink(new Link("a", "b", 2));
        graph.addLink(new Link("b", "c", 2));
        graph.addLink(new Link("a", "c", 5));
        graph.addLink(new Link("b", "d", 3));
        graph.addLink(new Link("c", "d", 1));
    }

    @Test
    public void test00() {
        Dijkstra dijkstra = new Dijkstra(graph, A);

        List<Node> pathAB = dijkstra.getPath(B);
        List<Node> expectedAB = Arrays.asList(A, B);
        assertEquals(pathAB, expectedAB);
        assertEquals(2, graph.getWeight(pathAB));

        List<Node> pathAC = dijkstra.getPath(C);
        List<Node> expectedAC = Arrays.asList(A, B, C);
        assertThat(pathAC, is(expectedAC));
        assertEquals(4, graph.getWeight(pathAC));
        
        List <Node> pathAD = dijkstra.getPath(D);
        List<Node> expectedAD = Arrays.asList(A, B, D);
        assertThat(pathAD, is(expectedAD));
        assertEquals(5, graph.getWeight(pathAD));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test01() {
    	Node Z = new Node ("", 0, 0);
    	graph.addNode(Z);
    	graph.addLink(new Link("a", "", 0));
    	
    	Dijkstra dijkstra = new Dijkstra(graph, A);

        List<Node> pathAZ = dijkstra.getPath(Z);
        List<Node> expectedAZ = Arrays.asList(A, Z);
        assertThat(pathAZ, is(expectedAZ));
        assertEquals(0, graph.getWeight(pathAZ));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test02() {
    	Node Y = new Node (null, 0, 0);
    	graph.addNode(Y);
    	graph.addLink(new Link("a", null, 0));
    	
    	Dijkstra dijkstra = new Dijkstra(graph, A);

        List<Node> pathAY = dijkstra.getPath(Y);
        List<Node> expectedAY = Arrays.asList(A, Y);
        assertThat(pathAY, is(expectedAY));
        assertEquals(0, graph.getWeight(pathAY));
        }

    	
    @Test
    public void test10() {
        Dijkstra dijkstra = new Dijkstra(graph, B);

        List<Node> pathBC = dijkstra.getPath(C);
        List<Node> expectedBC = Arrays.asList(B, C);
        assertEquals(expectedBC, pathBC);
        assertThat(pathBC, is(expectedBC));
        assertEquals(2, graph.getWeight(pathBC));

        List<Node> pathBA = dijkstra.getPath(A);
        assertNull(pathBA);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test11() {
    	Node Z = new Node ("", 0, 0);
    	graph.addNode(Z);
    	graph.addLink(new Link("b", "", 0));
    	
        Dijkstra dijkstra = new Dijkstra(graph, B);

        List<Node> pathBZ = dijkstra.getPath(Z);
        List<Node> expectedBZ = Arrays.asList(B, Z);
        assertEquals(expectedBZ, pathBZ);
        assertThat(pathBZ, is(expectedBZ));
        assertEquals(0, graph.getWeight(pathBZ));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test12() {
    	Node Y = new Node (null, 0, 0);
    	graph.addNode(Y);
    	graph.addLink(new Link("b", null, 0));
    	
        Dijkstra dijkstra = new Dijkstra(graph, B);

        List<Node> pathBY = dijkstra.getPath(Y);
        List<Node> expectedBY = Arrays.asList(B, Y);
        assertEquals(expectedBY, pathBY);
        assertThat(pathBY, is(expectedBY));
        assertEquals(0, graph.getWeight(pathBY));
    }
    
    @Test
    public void test20() {
        Dijkstra dijkstra = new Dijkstra(graph, D);

        List<Node> pathDB = dijkstra.getPath(B);
        assertNull(pathDB);
        
        List<Node> pathDC = dijkstra.getPath(C);
        assertNull(pathDC);
    }
    
    @Test
    public void test30() {
    	Dijkstra dijkstra = new Dijkstra(graph, D);
    	
    	List<Node> pathDD = dijkstra.getPath(D);
        List<Node> expectedDD = Arrays.asList(D);
        assertEquals(expectedDD, pathDD);
        assertThat(pathDD, is(expectedDD));
        assertEquals(0, graph.getWeight(pathDD));
    }
    
    @Test (expected = NullPointerException.class)
    public void test40(){
    	Graph graphnull;
    	graphnull=null;
    	Dijkstra dijkstra = new Dijkstra(graphnull, A);

        List<Node> pathAB = dijkstra.getPath(B);
        List<Node> expectedAB = Arrays.asList(A, B);
        assertEquals(pathAB, expectedAB);
        assertEquals(2, graph.getWeight(pathAB));
    }
}