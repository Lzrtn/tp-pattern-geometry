package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{
	
	@Override
	public abstract String getType();
	
	@Override
	public abstract Boolean isEmpty();
	
	@Override
	public abstract void translate(double dx, double dy);
	
	@Override
	public abstract Envelope getEnvelope();
	
	@Override
	public abstract AbstractGeometry clone();
	
	@Override
	public abstract void accept(GeometryVisitor visitor);
	
	public String asText() {
		WktVisitor visitor = new WktVisitor();
		this.accept(visitor);
		return visitor.getResult();
		
	}
}
