package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

public class LineString implements Geometry{
	private List<Point> points;
	
	public LineString() {
		//this.points = new ArrayList<Point>();
		this(null);
	}
	
	public LineString(List<Point> points) {
		//this.points = points;
		this.points = points != null ? points : new ArrayList<Point>();
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public Boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	
}
