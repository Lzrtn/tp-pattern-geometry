package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
	private List<Double> xs = new ArrayList<Double>();
	private List<Double> ys = new ArrayList<Double>();
	
	public void insert(Coordinate coordinate) {
		this.xs.add(coordinate.getX());
		this.ys.add(coordinate.getY());
	}
	
	public Envelope build() {
		double xmin = Collections.min(this.xs);
		double ymin = Collections.min(this.ys);
		double xmax = Collections.max(this.xs);
		double ymax = Collections.max(this.ys);
		Coordinate bottomLeft = new Coordinate(xmin, ymin);
		Coordinate topRight = new Coordinate(xmax, ymax);
		return new Envelope(bottomLeft, topRight);
	}
}
