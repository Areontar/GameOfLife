package ex.sl.cgolife.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import ex.sl.cgolife.util.Neighborhood;
import ex.sl.cgolife.util.Neighborhood.Location;
import ex.sl.cgolife.util.Neighborhood.NeighborhoodBuilder;

public class NeighborhoodTest {
	
	private NeighborhoodBuilder nb;
	
	@After
	public void teardown() {
		nb = null;
	}

	@Test
	public void testValuePresent() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, true);
		nb.addNeighbor(Location.SOUTH_EAST, true);
		nb.addNeighbor(Location.SOUTH, true);
		nb.addNeighbor(Location.SOUTH_WEST, true);
		nb.addNeighbor(Location.WEST, true);
		nb.addNeighbor(Location.NORTH_WEST, true);
		
		Neighborhood n = nb.build();
		
		assertTrue(n.getNeighborState(Location.CENTER));
		assertTrue(n.getNeighborState(Location.NORTH));
		assertTrue(n.getNeighborState(Location.NORTH_EAST));
		assertTrue(n.getNeighborState(Location.EAST));
		assertTrue(n.getNeighborState(Location.SOUTH_EAST));
		assertTrue(n.getNeighborState(Location.SOUTH));
		assertTrue(n.getNeighborState(Location.SOUTH_WEST));
		assertTrue(n.getNeighborState(Location.WEST));
		assertTrue(n.getNeighborState(Location.NORTH_WEST));
	}
	
	@Test
	public void testSomeValueNull() {
		nb = new NeighborhoodBuilder(true);

		nb.addNeighbor(Location.NORTH, true);
		nb.addNeighbor(Location.NORTH_EAST, true);
		nb.addNeighbor(Location.EAST, true);
		nb.addNeighbor(Location.WEST, true);
		nb.addNeighbor(Location.NORTH_WEST, true);
		
		Neighborhood n = nb.build();
		
		assertTrue(n.getNeighborState(Location.CENTER));
		assertTrue(n.getNeighborState(Location.NORTH));
		assertTrue(n.getNeighborState(Location.NORTH_EAST));
		assertTrue(n.getNeighborState(Location.EAST));
		assertNull(n.getNeighborState(Location.SOUTH_EAST));
		assertNull(n.getNeighborState(Location.SOUTH));
		assertNull(n.getNeighborState(Location.SOUTH_WEST));
		assertTrue(n.getNeighborState(Location.WEST));
		assertTrue(n.getNeighborState(Location.NORTH_WEST));
	}
	
	@Test
	public void testCannotBuildTwice() {
		nb = new NeighborhoodBuilder(true);
		
		Neighborhood n = nb.build();
		assertNotNull(n);
		
		n = nb.build();
		assertNull(n);
	}
	
	@Test
	public void testAliveCount() {
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
		
		assertTrue(n.getNeighborAliveCount() == 4);
		assertTrue(n.getNeighborDeadCount() == 4);
	}

}
