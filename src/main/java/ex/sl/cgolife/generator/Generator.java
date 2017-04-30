package ex.sl.cgolife.generator;

import ex.sl.cgolife.board.Board;
import ex.sl.cgolife.rule.Rule;
import ex.sl.cgolife.util.Neighborhood;

public class Generator {
	
	private Rule rule;

	public Generator(Rule rule) {
		this.rule = rule;
	}
	
	
	public Board generate(final Board origin) {
		final Board newBoard = origin.cloneToEmtpyBoard();
		
		for(int r=0; r< origin.getRowSize(); r++) {
			for(int c=0; c< origin.getColumnSize(); c++) {
				Neighborhood n = origin.getNeighborhood(r, c);
				newBoard.updateCell(r, c, getNewState(n));
			}
		}

		return newBoard;
	}
	
	private Boolean getNewState(final Neighborhood n) {
		return rule.getNewState(n);
	}

}
