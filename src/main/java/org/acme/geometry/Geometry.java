package org.acme.geometry;

public interface Geometry {
	
	public String getType();
	
	public Boolean isEmpty();
	
	public void translate(double dx, double dy);
	
	public Geometry clone();
	
	public Envelope getEnvelope();
	
	public void accept(GeometryVisitor geometryVisitor);
	
	public String asText();

}
