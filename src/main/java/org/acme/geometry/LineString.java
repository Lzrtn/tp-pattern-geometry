package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

public class LineString extends AbstractGeometry{
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
	
	@Override
	public void translate(double dx, double dy) {
		for(Point p: points) {
			p.translate(dx, dy);
		}
	}
	
	@Override
	public LineString clone() {
		return new LineString(this.points);
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		for(Point p: this.points) {
			builder.insert(p.getCoordinate());
		}
		Envelope envelope = builder.build();
		return envelope;
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
