package ex.sl.cgolife.rule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import ex.sl.cgolife.util.Neighborhood;
import ex.sl.cgolife.util.Neighborhood.Location;
import ex.sl.cgolife.util.Neighborhood.NeighborhoodBuilder;

public class B3S23Test {
	
	private final B3S23 rule =  new B3S23();
	
	private NeighborhoodBuilder nb;
	
	@After
	public void teardown() {
		nb = null;
	}

	@Test
	public void testRule1() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, false);
		nb.addNeighbor(Location.EAST, false);
		nb.addNeighbor(Location.SOUTH_EAST, false);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertFalse(newState);
	}
	
	@Test
	public void testRule2p1() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, false);
		nb.addNeighbor(Location.SOUTH_EAST, false);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertTrue(newState);
	}
	
	@Test
	public void testRule2p2() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, true);
		nb.addNeighbor(Location.SOUTH_EAST, false);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertTrue(newState);
	}
	
	@Test
	public void testRule3() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, true);
		nb.addNeighbor(Location.SOUTH_EAST, true);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertFalse(newState);
	}
	
	@Test
	public void testRule4() {
		nb = new NeighborhoodBuilder(false);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, true);
		nb.addNeighbor(Location.SOUTH_EAST, false);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertTrue(newState);
	}
	
	@Test
	public void testRule4p2() {
		nb = new NeighborhoodBuilder(false);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, false);
		nb.addNeighbor(Location.SOUTH_EAST, false);
		nb.addNeighbor(Location.SOUTH, false);
		nb.addNeighbor(Location.SOUTH_WEST, false);
		nb.addNeighbor(Location.WEST, false);
		nb.addNeighbor(Location.NORTH_WEST, false);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertFalse(newState);
	}
	
	@Test
	public void testCorner() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, null);
		nb.addNeighbor(Location.NORTH_EAST, null);
		nb.addNeighbor(Location.EAST, false);
		nb.addNeighbor(Location.SOUTH_EAST, true);
		nb.addNeighbor(Location.SOUTH, true);
		nb.addNeighbor(Location.SOUTH_WEST, null);
		nb.addNeighbor(Location.WEST, null);
		nb.addNeighbor(Location.NORTH_WEST, null);
		
		Neighborhood n = nb.build();
		boolean newState = rule.getNewState(n);
		assertTrue(newState);
	}

}
