package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer = new StringBuilder();

	public void visit(Point point) {
	    if(point.isEmpty()) {
	    	buffer.append("POINT EMPTY");
	    } else {
	    	buffer.append("POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
	    }
	}

	public void visit(LineString lineString) {
		if(lineString.isEmpty()) {
	    	buffer.append("LINESTRING EMPTY");
	    } else {
	    	String txt = "LINESTRING(";
	    	int numPoint = lineString.getNumPoints();
	    	boolean first = true;
	    	for(int i=0; i<numPoint; i++) {
	    		Coordinate c = lineString.getPointN(i+1).getCoordinate();
	    		if(!first) {
	    			txt += ",";
	    		}
	    		first = false;
	    		txt += c.getX()+" "+c.getY();
	    	}
	    	txt += ")";
	    	buffer.append(txt);
	    }
	}

	public String getResult() {
		return buffer.toString();
	}

}
