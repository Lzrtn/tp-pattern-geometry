package org.acme.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
	@Test
	public void testWktVisitorPointEmpty() {
		WktVisitor visitor = new WktVisitor();
		Geometry gp = new Point(new Coordinate());
		gp.accept(visitor);
		Assert.assertEquals( "POINT EMPTY", visitor.getResult() );
	}
	
	@Test
	public void testWktVisitorPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry gp = new Point(new Coordinate(3.0,4.0));
		gp.accept(visitor);
		Assert.assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}
	
	@Test
	public void testWktVisitorLineStringEmpty() {
		WktVisitor visitor = new WktVisitor();
		Geometry gls = new LineString();
		gls.accept(visitor);
		Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	@Test
	public void testWktVisitorLineString() {
		WktVisitor visitor = new WktVisitor();
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(0.0, 0.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		Geometry gls = new LineString(points);
		gls.accept(visitor);
		Assert.assertEquals("LINESTRING(3.0 4.0,0.0 0.0)", visitor.getResult());
	}

}
