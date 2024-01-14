package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWktWritePointEmpty() {
		Geometry g = new Point(new Coordinate());
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT EMPTY", writer.write(g));
	}
	
	@Test
	public void testWktWritePoint() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testWktWriteLineStringEmpty() {
		Geometry g = new LineString();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("LINESTRING EMPTY", writer.write(g));
	}
	
	@Test
	public void testWktWriteLineString() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(0.0, 0.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		LineString l = new LineString(points);
		WktWriter wkt = new WktWriter();
		Assert.assertEquals("LINESTRING(3.0 4.0,0.0 0.0)", wkt.write(l));
	}
}
