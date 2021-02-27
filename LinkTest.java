package es.upm.dit.adsw.ej1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Ejemplo de pruebas de la clase Link.
 * @author Daniel Gomez Campo
 * @author Mateo Sarria Franco de Sarabia
 * @author Andres Alfaro Fernandez
 * @version 07/02/2019
 */
public class LinkTest {

	@Test
	public void test01() {
		Link link = new Link ("A", "B", 1);
		assertEquals ("A", link.getSrc());
		assertEquals ("B", link.getDst());
		assertEquals (1, link.getWeight());
		assertEquals ("Link [src=" + "A" + ", dst=" + "B" + ", weight=" + 1 + "]", link.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test02() {
		Link link = new Link (null, "B", 1);
		assertEquals ("A", link.getSrc());
		assertEquals ("B", link.getDst());
		assertEquals (1, link.getWeight());
		assertEquals ("Link [src=" + null + ", dst=" + "B" + ", weight=" + 1 + "]", link.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test03() {
		Link link = new Link ("A", null, 1);
		assertEquals ("A", link.getSrc());
		assertEquals (null, link.getDst());
		assertEquals (1, link.getWeight());
		assertEquals ("Link [src=" + "A" + ", dst=" + null + ", weight=" + 1 + "]", link.toString());
	}
	@Test (expected = IllegalArgumentException.class)
	public void test04() {
		Link link = new Link ("A", "B", -1);
		assertEquals ("A", link.getSrc());
		assertEquals ("B", link.getDst());
		assertEquals (-1, link.getWeight());
		assertEquals ("Link [src=" + "A" + ", dst=" + "B" + ", weight=" + -1 + "]", link.toString());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test05() {
		Link link = new Link (null, null, -1);
		assertEquals (null, link.getSrc());
		assertEquals (null, link.getDst());
		assertEquals (-1, link.getWeight());
		assertEquals ("Link [src=" + null + ", dst=" + null + ", weight=" + -1 + "]", link.toString());
	}
}