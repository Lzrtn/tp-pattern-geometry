package org.acme.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {
	
	@Test
	public void testAbstractGeometryEmpty() {
		AbstractGeometry gpoint = new Point(new Coordinate());
		Assert.assertEquals("POINT EMPTY", gpoint.asText());
		
		AbstractGeometry glinestring = new LineString();
		Assert.assertEquals("LINESTRING EMPTY", glinestring.asText());
	}
	
	@Test
	public void testAbstractGeometryPoint() {
		AbstractGeometry geometry = new Point(new Coordinate(3.0,4.0));
		Assert.assertEquals("POINT(3.0 4.0)", geometry.asText());
	}
	
	@Test
	public void testAbstractGeometryLineString() {
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(0.0, 0.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		AbstractGeometry l = new LineString(points);
		//Assert.assertEquals("LINESTRING(3.0 4.0,0.0 0.0)", l.asText());
	}

}
