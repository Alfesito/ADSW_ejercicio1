package es.upm.dit.adsw.ej1;
import org.junit.*;
import static org.junit.Assert.*;
/**  
 * Pruebas de la clase Node 
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez  
 * @version 07/02/2019
 */ 
	public class NodeTest {  
		
		@Test     
		public void test01 () {         
			Node node = new Node ("a", 0, 0);         
			assertEquals("a", node.getName());         
			assertEquals(0, node.getX());         
			assertEquals(0, node.getY());         
			assertEquals("a", node.toString());     
			}     
		
		@Test (expected = IllegalArgumentException.class)
		public void test02() {        
			Node node = new Node("", 0, 0);
			assertEquals("",node.getName());
			assertEquals(0, node.getX());         
			assertEquals(0, node.getY());         
			assertEquals("", node.toString());
			
		}  
		
		@Test  (expected = IllegalArgumentException.class)   
		public void test03() {
			Node node = new Node(null, 0, 0);
			assertEquals(null,node.getName());
			assertEquals(0, node.getX());         
			assertEquals(0, node.getY());         
			assertEquals(null, node.toString());
			
		}
	} 