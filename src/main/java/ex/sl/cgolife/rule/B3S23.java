package ex.sl.cgolife.rule;

import ex.sl.cgolife.util.Neighborhood;
import ex.sl.cgolife.util.Neighborhood.Location;

public class B3S23 implements Rule{

	@Override
	public boolean getNewState(Neighborhood n) {
		if(n.getNeighborState(Location.CENTER)) { 
			if(n.getNeighborAliveCount() < 2) {
				return false;
			}
			if(n.getNeighborAliveCount() >= 2 && n.getNeighborAliveCount() <= 3) {
				return true;
			}
			if(n.getNeighborAliveCount() > 3) {
				return false;
			}
		} else {
			if(n.getNeighborAliveCount() == 3) {
				return true;
			}
		}
		return false;		
	}
	
	

}
