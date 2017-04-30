package ex.sl.cgolife.util;

import java.util.HashMap;

public class Neighborhood {
	
	public enum Location {
		CENTER,
		NORTH,
		NORTH_EAST,
		EAST,
		SOUTH_EAST,
		SOUTH,
		SOUTH_WEST,
		WEST,
		NORTH_WEST
	}

	private final HashMap<Location, Boolean> neighborhood_state;
	private int neighborAliveCount;
	
	protected Neighborhood(){
		neighborhood_state = new HashMap<>();
	}
	
	/**
	 * return the state of the Neighbor relevant to the center
	 * @param loc
	 * @return return the state, depends if the builder was made from data in a toroidal array or dead edge
	 */
	public Boolean getNeighborState(Location loc) {
		return neighborhood_state.get(loc);
	}
	
	private void setAliveCount(int aliveCount) {
		this.neighborAliveCount = aliveCount;
	}
	
	public int getNeighborAliveCount() {
		return neighborAliveCount;
	}
	
	public int getNeighborDeadCount() {
		return 8 - neighborAliveCount;
	}
	
	private void addNeighborState(Location loc, Boolean state) {
		neighborhood_state.put(loc, state);
	}
	
	
	
	public static class NeighborhoodBuilder {
		private boolean isBuilt = false;
		
		private final Neighborhood neighborhood = new Neighborhood();
		private int aliveCount;

		public NeighborhoodBuilder(boolean centerState) {
			neighborhood.addNeighborState(Location.CENTER, centerState);
		}
		
		public NeighborhoodBuilder addNeighbor(Location loc, Boolean state) {
			neighborhood.addNeighborState(loc, state);
			if(state != null && state) {
				aliveCount++;
			}
			return this;
		}
		
		public Neighborhood build() {
			if(!isBuilt){
				isBuilt = true;
				neighborhood.setAliveCount(aliveCount);
				return neighborhood;
			}
			System.err.println("Object was alreadyBuild");
			return null;
		}
	}
}
