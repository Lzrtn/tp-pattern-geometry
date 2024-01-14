package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class LineStringTest {
	
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

}
