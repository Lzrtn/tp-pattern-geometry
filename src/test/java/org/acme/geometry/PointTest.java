package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorPointEmpty() {
		Point p = new Point();
		Assert.assertTrue(p.getCoordinate().isEmpty());
	}

	@Test
	public void testConstructorPoint() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		Assert.assertEquals(c, p.getCoordinate());
	}

	@Test
	public void testPointGetType() {
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}
	
	@Test
	public void testPointIsEmpty() {
		Point p = new Point();
		Assert.assertTrue(p.isEmpty());
	}
	
	@Test
	public void testPointTranslate() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		p.translate(2.0, 1.0);
		Assert.assertEquals(5.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0, p.getCoordinate().getY(),EPSILON);
	}
	
	@Test
	public void testPointClone() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		Point copy = p.clone();
		copy.translate(2.0, 1.0);
		Assert.assertEquals(3.0, p.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(4.0, p.getCoordinate().getY(),EPSILON);
		Assert.assertEquals(5.0, copy.getCoordinate().getX(),EPSILON);
		Assert.assertEquals(5.0, copy.getCoordinate().getY(),EPSILON);
	}
	
	@Test
	public void testPointEnvelope() {
		Coordinate c = new Coordinate(3.0,4.0);
		Point p = new Point(c);
		Envelope envelope = p.getEnvelope();
		Assert.assertEquals("3.0,4.0;3.0,4.0", envelope.toString());
	}

}
