package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(3.0,4.0);
		Assert.assertEquals(3.0, c.getX(),EPSILON);
		Assert.assertEquals(4.0, c.getY(), EPSILON);
	}
	
	@Test
	public void testEmpty() {
		Coordinate c = new Coordinate();
		Assert.assertTrue(Double.isNaN(c.getX()));
		Assert.assertTrue(Double.isNaN(c.getY()));
		Assert.assertTrue(c.isEmpty());
	}
	
	@Test
	public void testString() {
		Coordinate c = new Coordinate(4.0,4.0);
		Assert.assertEquals("[4.0,4.0]", c.toString());
		Coordinate n = new Coordinate();
		Assert.assertEquals("[NaN,NaN]",n.toString());
	}
	

}
