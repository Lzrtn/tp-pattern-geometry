package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testConstructorEnvelope() {
		Envelope envelope = new Envelope();
		Assert.assertTrue(envelope.isEmpty());		
	}

	@Test
	public void testEnvelopeGet() {
		Coordinate c1 = new Coordinate(0.0,0.0);
		Coordinate c2 = new Coordinate(3.0,4.0);
		Envelope envelope = new Envelope(c1, c2);

		Assert.assertEquals(0.0, envelope.getXmin(),EPSILON);
		Assert.assertEquals(0.0, envelope.getYmin(),EPSILON);
		Assert.assertEquals(3.0, envelope.getXmax(),EPSILON);
		Assert.assertEquals(4.0, envelope.getYmax(),EPSILON);
	}

	@Test
	public void testEnvelopeToString() {
		Coordinate c1 = new Coordinate(3.0,4.0);
		Coordinate c2 = new Coordinate(0.0,0.0);
		Envelope envelope = new Envelope(c1, c2);
		Assert.assertEquals("3.0,4.0;0.0,0.0", envelope.toString());
	}


}
