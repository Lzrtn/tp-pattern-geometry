package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class TestEvelopeBuilder {
	@Test
	public void testEnvelopeBuilder() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		builder.insert(new Coordinate(0.0,0.0));
		builder.insert(new Coordinate(3.0,4.0));
		builder.insert(new Coordinate(3.0,3.0));
		Envelope envelope = builder.build();
		Assert.assertEquals("0.0,0.0;3.0,4.0", envelope.toString());
	}
}