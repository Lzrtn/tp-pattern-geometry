package org.acme.geometry;

public class Point implements Geometry{
	private Coordinate coordinate;
	
	public Point() {
		//this.coordinate = new Coordinate();
		this(Coordinate.EMPTY);
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	@Override
	public String getType() {
		return "Point";
	}
	
	@Override
	public Boolean isEmpty() {
		return this.coordinate.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		double xtrans = this.coordinate.getX()+dx;
		double ytrans = this.coordinate.getY()+dy;
		Coordinate ctrans = new Coordinate(xtrans,ytrans);
		this.coordinate = ctrans;
	}
	
	@Override
	public Point clone() {
		return new Point(this.coordinate);
	}
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(this.coordinate);
		Envelope envelope = builder.build();
		return envelope;
	}
}