package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class LineStringTest {
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testConstructorLineStringEmpty() {
		LineString l = new LineString();
		Assert.assertEquals(0, l.getNumPoints());
	}

	@Test
	public void testConstructorLineString() {
		Point p1 = new Point();
		Point p2 = new Point();
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		LineString l = new LineString(points);
		Assert.assertEquals(2, l.getNumPoints());
	}

	@Test
	public void testLineStringGetType() {
		LineString l = new LineString();
		Assert.assertEquals("LineString", l.getType());
	}

	@Test
	public void testLineStringGetNpoint() {
	Point p1 = new Point();
	Point p2 = new Point();
	Point[] pl = {p1, p2};
	List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
	LineString l = new LineString(points);
	Assert.assertEquals(p1, l.getPointN(0));
	}
	
	@Test
	public void testLineStringIsEmpty() {
		LineString l = new LineString();
		Assert.assertTrue(l.isEmpty());
	}
	
	@Test
	public void testLineStringTranslate() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(0.0, 0.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		LineString l = new LineString(points);
		l.translate(2.0, 1.0);
		Assert.assertEquals(5.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.0, l.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(2.0, l.getPointN(1).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(1.0, l.getPointN(1).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testLineStringClone() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(1.0, 1.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		LineString l = new LineString(points);
		LineString copy = l.clone();
		copy.translate(2.0, 1.0);
		Assert.assertEquals(5.0, copy.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(3.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.0, copy.getPointN(0).getCoordinate().getY(), EPSILON);
		Assert.assertEquals(4.0, l.getPointN(0).getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testLineStringEnvelope() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(1.0, 1.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		LineString l = new LineString(points);
		Envelope envelope = l.getEnvelope();
		Assert.assertEquals("1.0,1.0;3.0,4.0", envelope.toString());
	}

}
