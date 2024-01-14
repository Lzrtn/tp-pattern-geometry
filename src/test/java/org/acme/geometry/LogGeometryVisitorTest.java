package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogGeometryVisitorTest {
	
	@Test
	public void testLogGeometryVisitorPoint() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		Geometry g = new Point(new Coordinate(3.0, 4.0));
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0.", result);
	}
	
	@Test
	public void testLogGeometryVisitorLinestring() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		Coordinate c1 = new Coordinate(3.0, 4.0);
		Coordinate c2 = new Coordinate(0.0, 0.0);
		Point p1 = new Point(c1);
		Point p2 = new Point(c2);
		Point[] pl = {p1, p2};
		List<Point> points = new ArrayList<Point>(Arrays.asList(pl));
		Geometry g = new LineString(points);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		g.accept(visitor);
		String result = os.toString();
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s).",result);
	}
	
	@Test
	public void testLogGeometryVisitorEmpty() {
		ByteArrayOutputStream ospoint = new ByteArrayOutputStream();
		PrintStream outpoint = new PrintStream(ospoint);
		Geometry gpoint = new Point(new Coordinate());
		LogGeometryVisitor visitorpoint = new LogGeometryVisitor(outpoint);
		gpoint.accept(visitorpoint);
		String resultpoint = ospoint.toString();
		Assert.assertEquals("Je suis un point vide.", resultpoint);
		
		ByteArrayOutputStream oslinestring = new ByteArrayOutputStream();
		PrintStream outlinestring = new PrintStream(oslinestring);
		Geometry glinestring = new LineString();
		LogGeometryVisitor visitorlinestring = new LogGeometryVisitor(outlinestring);
		glinestring.accept(visitorlinestring);
		String resultlinestring = oslinestring.toString();
		Assert.assertEquals("Je suis une polyligne vide.", resultlinestring);
		
	}

}
